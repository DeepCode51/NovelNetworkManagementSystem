package com.ykjzone.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ykjzone.page.ChapterPage;
import com.ykjzone.page.NovelPage;
import com.ykjzone.pojo.*;
import com.ykjzone.service.*;
import com.ykjzone.util.RESTful;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cms")
public class CMSController {
    @Autowired
    NovelService novelService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    CollectService collectService;
    @Autowired
    ReadService readService;
    @Autowired
    TagService tagService;
    @Autowired
    BannerService bannerService;
    @Autowired
    AdvertisementService advertisementService;
    @Autowired
    ExcellentworksService excellentworksService;
    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;
    @Autowired
    UserGroupService userGroupService;

    @RequestMapping("/index")
    public String index(Model model){
        int[] range10 = new int[10];
        for(int i = 0; i < range10.length; i++){
            range10[i] = i + 1;
        }
        model.addAttribute("range10",range10);
        return "cms/index";
    }

    @RequestMapping("/novel_list")
    public String novelList(Model model, HttpSession session, NovelPage page){
        System.out.println("novel_list");
        NovelExample example = page.getExample();
        PageHelper.startPage(page.getP(),page.getCount());
        List<Novel> novels = novelService.getByExampleWithBLOBs(example);
        int total = (int) new PageInfo<>(novels).getTotal();
        page.setTotal(total);
        List<Category> categories = categoryService.getCategories();

        model.addAttribute("novels",novels);
        model.addAttribute("categories",categories);
        model.addAllAttributes(page.getParams());
        return "cms/novel_list";
    }

    @RequestMapping("/edit_novel")
    public String editNovel(Model model, HttpSession session, String novel_id){
        Novel novel = novelService.getByPrimaryKey(novel_id);
        model.addAttribute("novel",novel);
        return "cms/edit_novel";
    }

    @RequestMapping(value = "/update_novel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateNovel(HttpSession session, @Validated Novel novel, BindingResult br){
        if(br.hasErrors()){
            String message = br.getFieldError().getDefaultMessage();
            return RESTful.params_error(message);
        }else{
            novelService.updateSelective(novel);
            return RESTful.ok();
        }
    }


    @RequestMapping(value = "/delete_novel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteNovel(HttpSession session, String novel_id){
        Novel novel = novelService.getByPrimaryKey(novel_id);
        if(novel == null)
            RESTful.params_error("该小说不存在");
        collectService.deleteByNovelId(novel.getId());
        readService.deleteByNovelId(novel.getId());
        chapterService.deleteByNovelId(novel.getId());
        novelService.deleteById(novel.getId());
        return RESTful.ok();
    }

    @RequestMapping("/chapter_list")
    public String chapterList(Model model, ChapterPage page){
        ChapterExample example = page.getExample();
        Novel novel = novelService.getByPrimaryKey(page.getNovel_id());
        PageHelper.startPage(page.getP(),page.getCount());
        List<Chapter> chapters = chapterService.getChaptersByExample(example);
        // 获取并设置作品总数
        int total = (int) new PageInfo<>(chapters).getTotal();
        page.setTotal(total);
        model.addAttribute("novel",novel);
        model.addAttribute("chapters",chapters);
        model.addAllAttributes(page.getParams());
        return "cms/chapter_list";
    }

    @RequestMapping("/edit_chapter")
    public String editChapter(Model model, String chapter_id){
        Chapter chapter = chapterService.getChapterById(chapter_id);
        Novel novel = chapter.getNovel();
        model.addAttribute("chapter",chapter);
        model.addAttribute("novel",novel);
        return "cms/edit_chapter";
    }

    @RequestMapping(value = "/update_chapter", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateChapter(HttpSession session, @Validated Chapter chapter, BindingResult br){
        if(br.hasErrors()){
            return RESTful.params_error(br.getFieldError().getDefaultMessage());
        }
        // 设置chapter字数
        chapter.setWords_num();
        // 获取novel
        Chapter originChapter = chapterService.getChapterById(chapter.getId());
        Novel novel = originChapter.getNovel();
        // 更新novel的总字数
        novel.setWords_num(novel.getWords_num() - originChapter.getWords_num() + chapter.getWords_num());
        novelService.updateSelective(novel);
        // 保存chapter
        chapterService.updateByIdSelective(chapter);
        Map<String,Object> data = new HashMap<>();
        data.put("redirect","/cms/chapter_list?novel_id=" + novel.getId());
        return RESTful.result(200,"", data);
    }

    @RequestMapping(value = "/delete_chapter", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteChapter(HttpSession session, String chapter_id){
        User user = (User) session.getAttribute("user");
        Chapter chapter = chapterService.getChapterById(chapter_id);
        Novel novel = chapter.getNovel();
        if(chapter == null)
            return RESTful.params_error("该章节不存在");
        // 更新小说的总字数和章数
        novel.setWords_num(novel.getWords_num() - chapter.getWords_num());
        novel.setChapters_num(novel.getChapters_num() - 1);
        novelService.updateSelective(novel);
        // 删除章节
        chapterService.deleteById(chapter.getId());
        return RESTful.ok();
    }

    @RequestMapping(value = "/set_recommend", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String setRecommend(String novel_id){
        if(novel_id == null || novel_id.equals(""))
            return RESTful.params_error("小说id不能为空");
        Novel novel = novelService.getByPrimaryKey(novel_id);
        if(novel == null)
            return RESTful.params_error("该小说不存在");
        if(novel.getIs_recommend())
            return RESTful.params_error("该小说已推荐，请勿重复设置");
        novel.setIs_recommend(true);
        novelService.updateNovel(novel);
        return RESTful.ok();
    }

    @RequestMapping(value = "/cancel_recommend", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String cancelRecommend(String novel_id){
        if(novel_id == null || novel_id.equals(""))
            return RESTful.params_error("小说id不能为空");
        Novel novel = novelService.getByPrimaryKey(novel_id);
        if(novel == null)
            return RESTful.params_error("该小说不存在");
        if(!novel.getIs_recommend())
            return RESTful.params_error("该小说未推荐，请勿重复设置");
        novel.setIs_recommend(false);
        novelService.updateNovel(novel);
        return RESTful.ok();
    }

    // 获取分类和标签
    @RequestMapping(value = "/get_cate_list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getCateList(){
        List<Category> categories = categoryService.getCategoriesAndTags();
        Map<String,Object> data = new HashMap<>();
        data.put("cate_list",categories);
        return RESTful.ok(data);
    }

    // 上传图片
    @RequestMapping(value = "/upload_file", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String uploadImage(HttpServletRequest request, HttpServletResponse response, MultipartFile image){
        String originalFilename = image.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String fileName = RandomStringUtils.randomAlphanumeric(10) + suffix;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String date_str = sdf.format(new Date());
        String relativePath = "/media/image/account/" + date_str;
//        D:\IdeaProjects\xiaoshuo_SSM\target\xiaoshuo\media\image\account\2020\07\05\vkwmdgNNMR.jpg
        // 返回绝对路径
        String path = request.getServletContext().getRealPath(relativePath);
        //判断该路径是否存在
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File newFile = new File(path, fileName);
        try {
            image.transferTo(newFile);
            // 获取域名和端口号（如果有端口号）     localhost:8080
            StringBuffer url = request.getRequestURL();
            String domain = url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
//          http://127.0.0.1:8080/target\xiaoshuo\media\image\account\2020\07\05\vkwmdgNNMR.jpg
            String imageURL = domain + relativePath + "/" + fileName;
            Map<String,Object> data = new HashMap<>();
            data.put("url",imageURL);
            return RESTful.ok(data);
        } catch (IOException e) {
            e.printStackTrace();
            return RESTful.params_error("图片上传错误");
        }
    }

    // 分类管理

    @RequestMapping("/category_list")
    public String categoryList(Model model){
        List<Category> categories = categoryService.getAndNovelsNum();
        model.addAttribute("categories",categories);
        return "cms/category_list";
    }

    @RequestMapping(value = "/add_novel_category", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addNovelCategory(Category category){
        if(category.getName() == null || category.getName().equals(""))
            return RESTful.params_error("参数错误，分类名字不能为空");
        // 判断是否已存在
        CategoryExample example = new CategoryExample();
        example.createCriteria().andNameEqualTo(category.getName());
        List<Category> categories = categoryService.getByExample(example);
        if(categories.size() > 0)
            return RESTful.params_error("该分类名字已存在");
        categoryService.insert(category);
        return RESTful.ok();
    }

    @RequestMapping(value = "/edit_novel_category", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String editNovelCategory(Category category){
        if(category.getName() == null || category.getName().equals(""))
            return RESTful.params_error("参数错误，分类名字不能为空");
        categoryService.updateById(category);
        return RESTful.ok();
    }

    @RequestMapping(value = "/delete_novel_category", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteNovelCategory(Integer id){
        if(id == null)
            return RESTful.params_error("参数错误");
        categoryService.deleteById(id);
        return RESTful.ok();
    }

    // 标签管理
    @RequestMapping("tag_list")
    public String tagList(Model model){
        // 获取分类和标签
        List<Category> cate_tags = categoryService.getCategoriesAndTags();
        // 获取公共标签（无分类）
        List<Tag> common_tags = tagService.getNullCategory();
        model.addAttribute("cate_tags",cate_tags);
        model.addAttribute("common_tags",common_tags);
        return "cms/tag_list";
    }

    @RequestMapping("tag_detail")
    public String tagDetail(Model model, Integer category_id){
        Category category = categoryService.getOneAndTags(category_id);
        model.addAttribute("category",category);
        return "cms/tag_detail";
    }

    @RequestMapping(value = "/get_tags", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getTags(Integer category_id){
        List<Tag> tags;
        if(category_id == null)
            tags = tagService.getNullCategory();
        else
            tags = tagService.getByCategoryId(category_id);
        Map<String,Object> data = new HashMap<>();
        data.put("tags",tags);
        return RESTful.result(200,"", data);
    }

    @RequestMapping(value = "/add_tag", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addTag(@Validated Tag tag, BindingResult br){
        if(br.hasErrors())
            return RESTful.params_error(br.getFieldError().getDefaultMessage());


        Tag tagSameName = tagService.getByName(tag.getName());
        if(tagSameName != null)
            return RESTful.params_error("该标签已存在");

        tagService.insert(tag);

        Map<String,Object> data = new HashMap<>();
        data.put("tag",tag);
        return RESTful.ok(data);
    }

    @RequestMapping(value = "/edit_tag", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String editTag(@Validated Tag tag, BindingResult br){
        if(br.hasErrors())
            return RESTful.params_error(br.getFieldError().getDefaultMessage());

        Tag origin_tag = tagService.getById(tag.getId());
        if(origin_tag.getName() != null && origin_tag.getName().equals(tag.getName()))
            return RESTful.params_error("标签未作出修改");

        Tag tagSameName = tagService.getByName(tag.getName());
        if(tagSameName != null)
            return RESTful.params_error("该标签已存在");

        tagService.insert(tag);

        Map<String,Object> data = new HashMap<>();
        data.put("tag",tag);
        return RESTful.ok(data);
    }

    @RequestMapping(value = "/delete_tag", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteTag(Integer id){
        Tag origin_tag = tagService.getById(id);
        if(origin_tag == null)
            return RESTful.params_error("标签不存在，请刷新页面重试");

        tagService.delete(id);
        return RESTful.ok();
    }

    @RequestMapping(value = "/get_tag", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getTag(Integer id){
        Tag tag = tagService.getById(id);
        if(tag == null)
            return RESTful.params_error("该标签不存在，请刷新页面重试");
        Map<String,Object> data = new HashMap<>();
        data.put("tag",tag);
        return RESTful.ok(data);
    }

    // 轮播图管理

    @RequestMapping("/banners")
    public String banners(){
        return "cms/banners";
    }

    @RequestMapping(value = "/banner_list", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String bannerList(){
        List<Banner> banners = bannerService.getBanners();
        Map<String,Object> data = new HashMap<>();
        data.put("banners",banners);
        return RESTful.ok(data);
    }

    @RequestMapping(value = "/add_banner", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addBanner(@Validated Banner banner, BindingResult br){
        if(br.hasErrors())
            return RESTful.params_error(br.getFieldError().getDefaultMessage());
        bannerService.addBanner(banner);
        Map<String,Object> data = new HashMap<>();
        data.put("banner_id",banner.getId());
        return RESTful.ok(data);
    }

    @RequestMapping(value = "/edit_banner", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String editBanner(@Validated Banner banner, BindingResult br){
        if(br.hasErrors())
            return RESTful.params_error(br.getFieldError().getDefaultMessage());
        bannerService.updateBanner(banner);
        return RESTful.ok();
    }

    @RequestMapping(value = "/delete_banner", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteBanner(Integer id){
        if(id == null)
            return RESTful.params_error("参数错误");
        Banner banner = bannerService.getById(id);
        if(banner == null)
            return RESTful.params_error("该轮播图不存在");
        bannerService.deleteById(id);
        return RESTful.ok();
    }

    // 广告管理
    @RequestMapping("/ad_set")
    public String adSet(Model model){
        List<Advertisement> ads = advertisementService.getAdvertisements();
        model.addAttribute("ads",ads);
        return "cms/ad_set";
    }

    @RequestMapping(value = "/add_ad", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addAd(@Validated Advertisement advertisement, BindingResult br){
        if(br.hasErrors())
            return RESTful.params_error(br.getFieldError().getDefaultMessage());
        advertisementService.addAdvertisement(advertisement);
        Map<String,Object> data = new HashMap<>();
        data.put("ad",advertisement);
        return RESTful.ok(data);
    }

    @RequestMapping(value = "/edit_ad", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String editAd(@Validated Advertisement advertisement, BindingResult br){
        if(br.hasErrors())
            return RESTful.params_error(br.getFieldError().getDefaultMessage());
        advertisementService.updateAdvertisement(advertisement);
        Map<String,Object> data = new HashMap<>();
        data.put("ad",advertisement);
        return RESTful.ok(data);
    }

    @RequestMapping(value = "/get_ads", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAds(){
        Map<String,Object> data = new HashMap<>();
        List<Advertisement> ads = advertisementService.getAdvertisements();
        data.put("ads",ads);
        return RESTful.ok(data);
    }

    // 优秀作品展示

    @RequestMapping("/excellent")
    public String excellentWorks(Model model){
        List<Excellentworks> excellent_workses = excellentworksService.getExcellentworkses();
        model.addAttribute("excellent_workses",excellent_workses);
        return "cms/excellent_works";
    }

    @RequestMapping(value = "/edit_excellent_works", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String editExcellentWorks(@Validated Excellentworks excellentworks, BindingResult br){
        if(br.hasErrors())
            return RESTful.params_error(br.getFieldError().getDefaultMessage());
        excellentworksService.updateExcellentworks(excellentworks);
        return RESTful.ok();
    }

    // 员工管理
    @RequestMapping("/staffs")
    public String staffs(Model model){
        List<User> staffs = userService.getStaffs();
        model.addAttribute("staffs",staffs);
        return "cms/staffs";
    }
    @RequestMapping("/add_staff")
    public String addStaff(Model model, String message){
        List<Group> groups = groupService.getGroups();
        model.addAttribute("groups",groups);
        if(message != null)
            model.addAttribute("message",message);
        return "cms/add_staff";
    }

    @RequestMapping(value = "/insert_staff", method = RequestMethod.POST)
    public String insertStaff(Model model, String telephone, @RequestBody @RequestParam("groups") List<Integer> group_ids){
        List<Group> groups = groupService.getInIds(group_ids);
        User user = userService.getByTelephone(telephone);
        if(user == null){
            model.addAttribute("message","手机号不存在");
            return "redirect:/cms/add_staff";
        }
        // 将用户与组的关系清空
        userGroupService.deleteByUser(user);
        // 将用户添加进组
        for(Group group : groups){
            userGroupService.add(user,group);
        }
        // 将用户设置为员工
        user.setIs_staff(true);
        userService.updateSelective(user);
        return "redirect:/cms/staffs";
    }

    @RequestMapping("edit_staff")
    public String editStaff(Model model, String staff_id){
        User user = userService.getById(staff_id);
        user.setGroups(groupService.getByUserId(user.getId()));
        if(user.getIs_staff() || user.getIs_superuser()){
            List<Group> groups = groupService.getGroups();
            model.addAttribute("staff",user);
            model.addAttribute("groups",groups);
            return "cms/edit_staff";
        }else{
            return "redirect:/cms/staffs";
        }
    }

    @RequestMapping(value = "/delete_staff", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteStaff(String staff_id){
        User user = userService.getById(staff_id);
        if(user == null)
            return RESTful.params_error("用户不存在，请刷新页面重试");
        // 将用户与组的关系清空
        userGroupService.deleteByUser(user);
        // 将用户设置为非员工
        user.setIs_staff(false);
        userService.updateSelective(user);
        return RESTful.ok();
    }
}
