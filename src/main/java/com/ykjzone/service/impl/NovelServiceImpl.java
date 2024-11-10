package com.ykjzone.service.impl;

import com.github.pagehelper.PageHelper;
import com.ykjzone.mapper.NovelMapper;
import com.ykjzone.pojo.Category;
import com.ykjzone.pojo.Novel;
import com.ykjzone.pojo.NovelExample;
import com.ykjzone.pojo.User;
import com.ykjzone.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NovelServiceImpl implements NovelService {
    @Autowired
    NovelMapper novelMapper;

    @Override
    public List<Novel> getByExampleWithBLOBs(NovelExample example) {
        return novelMapper.selectByExampleWithBLOBs(example);
    }

    public List<Novel> getRecommendNovels(Boolean getDetail) {
        NovelExample example = new NovelExample();
        NovelExample.Criteria criteria = example.createCriteria();
        criteria.andIs_recommendEqualTo(true);
        example.setOrderByClause("pub_date desc");
        List<Novel> novels = new ArrayList<>();
        if(getDetail){
            novels = novelMapper.selectByExampleWithBLOBs(example);
        }else{
            novels = novelMapper.selectManyRelated(example);
        }
        return novels;
    }

    @Override
    public List<Novel> getRecommendNovels(int category_id, Boolean getDetail) {
        NovelExample example = new NovelExample();
        NovelExample.Criteria criteria = example.createCriteria();
        criteria.andIs_recommendEqualTo(true);
        criteria.andCategory_idEqualTo(category_id);
        example.setOrderByClause("pub_date desc");
        List<Novel> novels = new ArrayList<>();
        if(getDetail){
            novels = novelMapper.selectByExampleWithBLOBs(example);
        }else{
            novels = novelMapper.selectManyRelated(example);
        }
        return novels;
    }

    public List<Novel> getNewNovels() {
        NovelExample example = new NovelExample();
        example.setOrderByClause("pub_date desc");
        List<Novel> novels = novelMapper.selectByExampleWithBLOBs(example);
        return novels;
    }

    public List<List<Novel>> getCateHotNovels(){
        String[][] all_category_name = Category.CATEGORY_NAME;
        List<List<Novel>> cate_hot_novels = new ArrayList<List<Novel>>();
        for(int i = 0; i < 6; i++){
            int id1 = i*2+1;
            int id2 = i*2+2;

            NovelExample example = new NovelExample();
            example.setOrderByClause("views desc");

            NovelExample.Criteria criteria = example.createCriteria();
            List<Integer> ids = new ArrayList<>();
            ids.add(id1);
            ids.add(id2);
            criteria.andCategory_idIn(ids);

            PageHelper.offsetPage(0, 5);
            List<Novel> novels = novelMapper.selectManyRelated(example);
            cate_hot_novels.add(novels);
        }
        return cate_hot_novels;
    }

    public List<Novel> getRankNovels(){
        NovelExample example = new NovelExample();
        example.setOrderByClause("views desc");
        List<Novel> novels = novelMapper.selectManyRelated(example);
        return novels;
    }

    public Novel getByPrimaryKey(String id){
        Novel novel = novelMapper.selectByPrimaryKey(id);
        return novel;
    }

    @Override
    public List<Map<String,Object>> getReadedNovels(User user, int count) {
        PageHelper.offsetPage(0,count);
        List<Novel> readed_novels =  novelMapper.selectReadedNovelsByUserId(user.getId(), false);
        System.out.println("readed_novels");
        for(Novel novel : readed_novels){
            System.out.println(novel);
        }
        // 查看每一个Novel是否被收藏
        PageHelper.offsetPage(0,count);
        List<Novel> read_collected_novels = novelMapper.selectReadedNovelsByUserId(user.getId(), true);
        System.out.println("read_collected_novels");
        for(Novel novel : read_collected_novels){
            System.out.println(novel);
        }
        System.out.println("read_collected_novels: " + read_collected_novels);
        Iterator read_iterator = readed_novels.iterator();
        Iterator read_collected_iterator = read_collected_novels.iterator();
        // novels: [{"novel":Novel,"is_collect":true}, ...]
        List<Map<String,Object>> novels = new ArrayList<>();
        while(read_collected_iterator.hasNext()){
            Novel c_novel =(Novel) read_collected_iterator.next();
            while(read_iterator.hasNext()){
                Novel novel  = (Novel) read_iterator.next();;
                Map<String,Object> map = new HashMap<>();
                map.put("novel",novel);
                if(novel.getId().equals(c_novel.getId())){
                    map.put("is_collect", true);
                    novels.add(map);
                    break;      // 遍历read_collected的下一个
                }
                else map.put("is_collect", false);
                novels.add(map);
            }
        }
        while(read_iterator.hasNext()){
            Novel novel  = (Novel) read_iterator.next();;
            Map<String,Object> map = new HashMap<>();
            map.put("novel",novel);
            map.put("is_collect", false);
            novels.add(map);
        }
        return novels;
    }

    @Override
    public List<Novel> getCollect(User user) {
        return novelMapper.selectCollectByUserId(user.getId());
    }

    @Override
    public List<Novel> getWorks(User user) {
        return novelMapper.selectWorksByUserId(user.getId());
    }

    @Override
    public void addNovel(Novel novel) {
        novelMapper.insert(novel);
    }

    @Override
    public void updateNovelWithBLOBs(Novel novel) {
        novelMapper.updateByPrimaryKeyWithBLOBs(novel);
    }

    @Override
    public void updateNovel(Novel novel) {
        novelMapper.updateByPrimaryKey(novel);
    }

    @Override
    public void updateSelective(Novel novel) {
        novelMapper.updateByPrimaryKeySelective(novel);
    }

    @Override
    public void deleteById(String novel_id) {
        novelMapper.deleteByPrimaryKey(novel_id);
    }
}
