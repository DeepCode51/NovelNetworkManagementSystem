package com.ykjzone.service;

import com.ykjzone.pojo.Novel;
import com.ykjzone.pojo.NovelExample;
import com.ykjzone.pojo.User;

import java.util.List;
import java.util.Map;

public interface NovelService {
    public List<Novel> getByExampleWithBLOBs(NovelExample example);

    public List<Novel> getRecommendNovels(Boolean getDetail);

    public List<Novel> getRecommendNovels(int category_id, Boolean getDetail);

    public List<Novel> getNewNovels();

    public List<List<Novel>> getCateHotNovels();

    public List<Novel> getRankNovels();

    public Novel getByPrimaryKey(String id);

    public List<Map<String,Object>> getReadedNovels(User user, int count);

    public List<Novel> getCollect(User user);

    public List<Novel> getWorks(User user);

    public void addNovel(Novel novel);

    public void updateNovel(Novel novel);

    public void updateNovelWithBLOBs(Novel novel);

    public void updateSelective(Novel novel);

    public void deleteById(String novel_id);
}
