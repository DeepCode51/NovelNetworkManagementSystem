package com.ykjzone.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.Session;
import com.ykjzone.page.Page;
import com.ykjzone.page.RankPage;
import com.ykjzone.page.WholePage;
import com.ykjzone.pojo.*;
import com.ykjzone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class NovelController {
    @Autowired
    BannerService bannerService;
    @Autowired
    AdvertisementService advertisementService;
    @Autowired
    NovelService novelService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    ExcellentworksService excellentworksService;
    @Autowired
    ReadService readService;
    @Autowired
    CollectService collectService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    TagService tagService;

    @RequestMapping("")
    public String index(Model model, HttpSession session){
        String[][] all_category_name = Category.CATEGORY_NAME;

        List<Banner> banners = bannerService.getBanners();
        List<Advertisement> ads = advertisementService.getAdvertisements();

        PageHelper.offsetPage(0,6);
        List<Novel> rec_novels_1_6 = novelService.getRecommendNovels(true);

        PageHelper.offsetPage(6,11);
        List<Novel> rec_novels_7_17 = novelService.getRecommendNovels(false);

        PageHelper.offsetPage(0,11);
        List<Novel> new_novels_1_11 = novelService.getNewNovels();

        List<List<Novel>>  cate_hot_novels = novelService.getCateHotNovels();

        List<Excellentworks> excellent_workses = excellentworksService.getExcellentworkses();

        PageHelper.offsetPage(0,11);
        List<Novel> rank_novels = novelService.getRankNovels();

        model.addAttribute("all_category_name",all_category_name);
        model.addAttribute("banners",banners);
        model.addAttribute("ads",ads);
        model.addAttribute("excellent_workses",excellent_workses);
        model.addAttribute("rec_novels_1_6",rec_novels_1_6);
        model.addAttribute("rec_novels_7_17",rec_novels_7_17);
        model.addAttribute("new_novels_1_11",new_novels_1_11);
        model.addAttribute("cate_hot_novels",cate_hot_novels);
        model.addAttribute("rank_novels",rank_novels);
        model.addAttribute("user", session.getAttribute("user"));
        return "novel/index";
    }

    @RequestMapping("/detail/{id}")
    public String detail(HttpSession session, Model model, @PathVariable String id){
        Novel novel = novelService.getByPrimaryKey(id);
        User user = (User) session.getAttribute("user");
        // 判断用户是否收藏
        Boolean is_collect = false;
        if(user != null){
            List<UserCollect> collects = collectService.getByUidAndNid(user.getId(),id);
            if(collects.size() > 0)
                is_collect = true;
        }
        List<Chapter> chapters = chapterService.getChaptersByNovelId(id);
        PageHelper.offsetPage(0,12);
        List<Novel> recommend_novels = novelService.getRecommendNovels(novel.getCategory().getId(),false);
        String[][] all_category_name = Category.CATEGORY_NAME;

        model.addAttribute("all_category_name",all_category_name);
        model.addAttribute("novel", novel);
        model.addAttribute("chapters", chapters);
        model.addAttribute("is_collect",is_collect);
        model.addAttribute("recent_title",chapters.size() > 0 ? chapters.get(0).getTitle() : "暂无章节");
        model.addAttribute("recent_date",chapters.size() > 0 ? chapters.get(0).getPub_date() : "");
        model.addAttribute("recommend_novels",recommend_novels);
        return "novel/detail";
    }

    @RequestMapping("/chapter/{id}")
    public String chapter(HttpSession session, Model model, @PathVariable String id){
        Chapter chapter = chapterService.getChapterById(id);
        String[][] all_category_name = Category.CATEGORY_NAME;
        User user = (User) session.getAttribute("user");
        Boolean is_collect = false;
        if(user != null){
            // 设置为最近阅读
            List<UserRead> urs = readService.select(user, chapter.getNovel());
            if(urs == null || urs.size() == 0){        // 未收藏
                readService.insert(user, chapter.getNovel());
                System.out.println("收藏");
            }
            // 判断用户是否收藏
            List<UserCollect> collects = collectService.getByUidAndNid(user.getId(),chapter.getNovel().getId());
            if(collects.size() > 0)
                is_collect = true;
        }


        // 获取前后页的chapter_id
        if(chapter.getNumber() > 1){
            int previous_num = chapter.getNumber() - 1;
            String previous_id = chapterService.getIdByNovelAndNum(chapter.getNovel(),previous_num);
            model.addAttribute("previous_id",previous_id);
        }
        if(chapter.getNumber() < chapter.getNovel().getChapters_num()){
            int next_num = chapter.getNumber() + 1;
            String next_id = chapterService.getIdByNovelAndNum(chapter.getNovel(),next_num);
            model.addAttribute("next_id",next_id);
        }

        model.addAttribute("user",user);
        model.addAttribute("is_collect",is_collect);
        model.addAttribute("chapter",chapter);
        model.addAttribute("all_category_name",all_category_name);
        return "novel/chapter";
    }

    @RequestMapping("/whole")
    public String whole(Model model, WholePage page){
        // 获取小说
        NovelExample example = page.getExample();
        PageHelper.startPage(page.getP(),page.getCount());
        List<Novel> novels = novelService.getByExampleWithBLOBs(example);
        model.addAttribute("novels",novels);
        // 获取并设置作品总数
        int total = (int) new PageInfo<>(novels).getTotal();
        page.setTotal(total);
        // 获取分页参数
        model.addAllAttributes(page.getParams());
        model.addAllAttributes(page.getQuery_strings());
        // 获取推荐小说
        PageHelper.offsetPage(0,20);
        List<Novel> recommend_novels = novelService.getRecommendNovels(false);
        model.addAttribute("recommend_novels",recommend_novels);
        // 获取所有分类
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);
        model.addAttribute("all_category_name",Category.CATEGORY_NAME);
        return "novel/whole";
    }

    @RequestMapping("/rank")
    public String rank(Model model, RankPage page){
        NovelExample example = page.getExample();
        PageHelper.startPage(page.getP(),page.getCount());
        List<Novel> novels = novelService.getByExampleWithBLOBs(example);
        model.addAttribute("novels",novels);

        int total = (int) new PageInfo<>(novels).getTotal();
        page.setTotal(total);
        model.addAllAttributes(page.getParams());

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);

        PageHelper.offsetPage(0,20);
        List<Novel> recommend_novels = novelService.getRecommendNovels(false);
        model.addAttribute("recommend_novels",recommend_novels);

        return "novel/rank";
    }

    @RequestMapping("/{category_name}")
    public String category(Model model, @PathVariable String category_name){
        String[] category = new String[2];
        int count = 0;
        for(String[] c : Category.CATEGORY_NAME){
            count++;
            if(c[0].equals(category_name)){
                category = c;
                break;
            }
        }
        if(category[0] == null)
            return "redirect:/404";

        model.addAttribute("category_en_name", category[0]);
        model.addAttribute("category_ch_name", category[1]);

//        Category c = categoryService.getAndTagsByName(category[1]);
        Category c = categoryService.getOneAndTags(count);
        if(c == null)
            return "redirect:/404";

        model.addAttribute("tags",c.getTags());
        model.addAttribute("all_category_name",Category.CATEGORY_NAME);
        model.addAttribute("category",c);

        // 获取推荐小说
        NovelExample recommend_example = new NovelExample();
        recommend_example.createCriteria().andCategory_idEqualTo(c.getId()).andIs_recommendEqualTo(true);
        PageHelper.offsetPage(0,15);
        List<Novel> recommend_novels = novelService.getByExampleWithBLOBs(recommend_example);
        List<Novel> recommend_novels_1_5 = new ArrayList<>();
        List<Novel> recommend_novels_6_15 = new ArrayList<>();
        for(int i = 0; i < recommend_novels.size(); i++){
            if(i < 5)
                recommend_novels_1_5.add(recommend_novels.get(i));
            else
                recommend_novels_6_15.add(recommend_novels.get(i));
        }

        // 获取小说排名
        NovelExample rank_example = new NovelExample();
        rank_example.createCriteria().andCategory_idEqualTo(c.getId());
        rank_example.setOrderByClause("views desc");
        PageHelper.offsetPage(0,10);
        List<Novel> rank_novels = novelService.getByExampleWithBLOBs(rank_example);
        Novel rank_novels_1 = rank_novels.remove(0);

        // 获取新书
        NovelExample new_example = new NovelExample();
        new_example.createCriteria().andCategory_idEqualTo(c.getId());
        new_example.setOrderByClause("pub_date desc");
        PageHelper.offsetPage(0,19);
        List<Novel> new_novels = novelService.getByExampleWithBLOBs(new_example);
        Novel new_novels_1 = null;
        List<Novel> new_novels_2_10 = new ArrayList<>();
        List<Novel> new_novels_11_19 = new ArrayList<>();
        for(int i = 0; i < new_novels.size(); i++){
            if(i == 0)
                new_novels_1 = new_novels.get(i);
            else if(i < 10)
                new_novels_2_10.add(new_novels.get(i));
            else
                new_novels_11_19.add(new_novels.get(i));
        }
        model.addAttribute("recommend_novels_1_5",recommend_novels_1_5);
        model.addAttribute("recommend_novels_6_15",recommend_novels_6_15);
        model.addAttribute("rank_novels_1",rank_novels_1);
        model.addAttribute("rank_novels",rank_novels);
        model.addAttribute("new_novels_1",new_novels_1);
        model.addAttribute("new_novels_2_10",new_novels_2_10);
        model.addAttribute("new_novels_11_19",new_novels_11_19);
        return "novel/category";
    }

    @RequestMapping("/404")
    public String http404(Model model){
        PageHelper.offsetPage(0,10);
        List<Novel> recommend_novels = novelService.getRecommendNovels(false);
        System.out.println(recommend_novels.size());
        model.addAttribute("recommend_novels",recommend_novels);
        return "error/404";
    }
}
