package com.ykjzone.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ykjzone.page.ChapterPage;
import com.ykjzone.pojo.*;
import com.ykjzone.service.*;
import com.ykjzone.page.NovelPage;
import com.ykjzone.util.RESTful;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    NovelService novelService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CollectService collectService;
    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);

        List<Map<String,Object>> readed_novels = novelService.getReadedNovels(user, 6);
        System.out.println(readed_novels);
        model.addAttribute("readed_novels",readed_novels);

        PageHelper.offsetPage(0,6);
        List<Novel> collected_novels = novelService.getCollect(user);
        model.addAttribute("collected_novels",collected_novels);

        PageHelper.offsetPage(0,6);
        List<Novel> my_works = novelService.getWorks(user);
        model.addAttribute("my_works",my_works);

        return "account/index";
    }

    @RequestMapping("/recently_read")
    public String recentlyRead(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Map<String,Object>> novels = novelService.getReadedNovels(user, 30);
        model.addAttribute("novels",novels);

        for(Map<String,Object> map : novels){
            Novel novel = (Novel) map.get("novel");
        }

        return "account/recently_read";
    }

    @RequestMapping("/my_collect")
    public String myCollect(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Novel> collected_novels = novelService.getCollect(user);
        model.addAttribute("collected_novels",collected_novels);
        return "account/my_collect";
    }

    @RequestMapping("/become_writer")
    public String becomeWriter(Model model, HttpSession session, String message){
        User user = (User) session.getAttribute("user");
        if(user.getIs_author())
            return "account/index";
        model.addAttribute("message",message);
        return "account/become_writer";
    }

    @RequestMapping("/submit_become_writer")
    public String submitBecomeWriter(Model model, HttpSession session, String pen_name) {
        System.out.println("pen_name: " + pen_name);
        User user = (User) session.getAttribute("user");
        if (user.getIs_author()){
            model.addAttribute("message", "您已是作家");
            return "redirect:/account/become_writer";
        }
        user.setIs_author(true);
        user.setPen_name(pen_name);
        userService.updateSelective(user);
        return "redirect:/account/index";
    }

    // ********* 作家专区 ***********
    // 作品列表
    @RequestMapping("/novel_list")
    public String novelList(Model model, HttpSession session, NovelPage page){
        NovelExample example = page.getExample();
        NovelExample.Criteria criteria = page.getCriteria();
        User user = (User) session.getAttribute("user");
        criteria.andAuthor_idEqualTo(user.getId());     // 设置用户
        // 获取用户的所有作品
        PageHelper.startPage(page.getP(),page.getCount());
        List<Novel> novels = novelService.getByExampleWithBLOBs(example);
        // 获取并设置作品总数
        int total = (int) new PageInfo<>(novels).getTotal();
        page.setTotal(total);
        // 获取分类列表
        List<Category> categories = categoryService.getCategories();

        Map<String,Object> context = new HashMap<String,Object>();
        context.put("novels", novels);
        context.put("categories",categories);
        context.putAll(page.getParams());
        model.addAllAttributes(context);

        return "account/novel_list";
    }

    // 发布作品 GET
    @RequestMapping(value = "/pub_novel", method = RequestMethod.GET)
    public String pubNovel(){
        return "account/pub_novel";
    }

    @RequestMapping(value = "/add_novel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addNovel(HttpSession session, @Validated Novel novel, BindingResult br){
        if(br.hasErrors()){
//            List<FieldError> errors = br.getFieldErrors();
//            for(FieldError error : errors){
//                System.out.println(error.getField() + error.getDefaultMessage());
//            }
            return RESTful.params_error(br.getFieldError().getDefaultMessage());
        }else{
            novel.generate();
            User user = (User) session.getAttribute("user");
            novel.setAuthor(user);
            novelService.addNovel(novel);
            return RESTful.ok();
        }
    }

    @RequestMapping(value = "/edit_novel", method = RequestMethod.GET)
    public String editNovel(Model model, String novel_id){
        if(novel_id == null || novel_id.equals(""))
            return "account/index";
        Novel novel = novelService.getByPrimaryKey(novel_id);
        model.addAttribute("novel", novel);
        return "account/pub_novel";
    }

    @RequestMapping(value = "/update_novel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateNovel(HttpSession session, @Validated Novel novel, BindingResult br){
        if(br.hasErrors()){
            String message = br.getFieldError().getDefaultMessage();
            return RESTful.params_error(message);
        }else{
            User user = (User) session.getAttribute("user");
            novel.setAuthor(user);
            novelService.updateNovel(novel);
//            System.out.println("price: " + novel.getPrice());
            return RESTful.ok();
        }
    }

    @RequestMapping(value = "/delete_novel", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteNovel(HttpSession session, String novel_id){
        User user = (User) session.getAttribute("user");
        Novel novel = novelService.getByPrimaryKey(novel_id);
        if(novel == null)
            RESTful.params_error("该小说不存在");
        if(!novel.getAuthor().getId().equals(user.getId()))
            return RESTful.unauth("您不是该小说的作者");
        novelService.deleteById(novel.getId());
        return RESTful.ok();
    }

    @RequestMapping("/choose_novel")
    public String chooseNovel(Model model, HttpSession session, Integer operate){
        User user = (User) session.getAttribute("user");
        NovelExample example = new NovelExample();
        NovelExample.Criteria criteria = example.createCriteria();
        criteria.andAuthor_idEqualTo(user.getId());
        example.setOrderByClause("is_complete, pub_date desc");
        List<Novel> novels = novelService.getByExampleWithBLOBs(example);
        model.addAttribute("novels", novels);
        model.addAttribute("title", operate == 1 ? "写小说" : "查看章节");
        model.addAttribute("operate", operate);
        return "account/choose_novel";
    }

    @RequestMapping("/write_chapter")
    public String writeChapter(Model model, HttpSession session, String novel_id){
        User user = (User) session.getAttribute("user");
        Novel novel = novelService.getByPrimaryKey(novel_id);
        if(novel == null)
            return "account/index";
        if(!user.getId().equals(novel.getAuthor().getId()))
            return "account/index";
        model.addAttribute("novel",novel);
        return "account/write_chapter";
    }

    @RequestMapping(value = "/add_chapter", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addChapter(HttpSession session, @Validated Chapter chapter, BindingResult br){
        if(br.hasErrors()){
            return RESTful.params_error(br.getFieldError().getDefaultMessage());
        }
        // 设置chapter字数
        chapter.setWords_num();
        // 获取novel
        Novel novel = novelService.getByPrimaryKey(chapter.getNovel_id());
        // 更新novel的章节数
        novel.setChapters_num(novel.getChapters_num() + 1);
        // 更新novel的总字数
        novel.setWords_num(novel.getWords_num() + chapter.getWords_num());
        novelService.updateNovel(novel);
        // 保存chapter
        chapter.generate();
        chapterService.insert(chapter);
        return RESTful.ok();
    }

    @RequestMapping(value = "/chapter_list")
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
        return "account/chapter_list";
    }

    @RequestMapping("/edit_chapter")
    public String editChapter(Model model, String chapter_id){
        Chapter chapter = chapterService.getChapterById(chapter_id);
        Novel novel = chapter.getNovel();
        model.addAttribute("chapter",chapter);
        model.addAttribute("novel",novel);
        return "account/write_chapter";
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
        return RESTful.ok();
    }

    @RequestMapping(value = "/delete_chapter", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteChapter(HttpSession session, String chapter_id){
        User user = (User) session.getAttribute("user");
        Chapter chapter = chapterService.getChapterById(chapter_id);
        Novel novel = chapter.getNovel();
        if(chapter == null)
            return RESTful.params_error("该章节不存在");
        if(!novel.getAuthor().getId().equals(user.getId()))
            return RESTful.unauth("您不是该小说的作者");
        // 更新小说的总字数和章数
        novel.setWords_num(novel.getWords_num() - chapter.getWords_num());
        novel.setChapters_num(novel.getChapters_num() - 1);
        novelService.updateSelective(novel);
        // 删除章节
        chapterService.deleteById(chapter.getId());
        return RESTful.ok();
    }

    // 收藏图书
    @RequestMapping(value = "/collect", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String collectNovel(HttpSession session, String novel_id){
        User user = (User) session.getAttribute("user");
        // 判断该小说是否已经收藏
        List<UserCollect> collects = collectService.getByUidAndNid(user.getId(), novel_id);
        if(collects.size() > 0)
            return RESTful.params_error("不能重复收藏，请刷新页面");
        int insert_rows = collectService.insert(user.getId(),novel_id);
        if(insert_rows <= 0)
            return RESTful.params_error("插入失败，小说不存在");
        return RESTful.ok();
    }

    @RequestMapping(value = "/cancel_collect", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String cancelCollect(HttpSession session, String novel_id){
        User user = (User) session.getAttribute("user");
        int delete_rows = collectService.delete(user.getId(),novel_id);
        if(delete_rows <= 0)
            return RESTful.params_error("该小说未收藏");
        return RESTful.ok();
    }

    // 获取分类和标签
    @RequestMapping(value = "/get_cate_list", produces = "application/json;charset=UTF-8")
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


}