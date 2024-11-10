package com.ykjzone.service.impl;

import com.ykjzone.mapper.CategoryMapper;
import com.ykjzone.pojo.Category;
import com.ykjzone.pojo.CategoryExample;
import com.ykjzone.pojo.Tag;
import com.ykjzone.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategories() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public List<Category> getCategoriesAndTags() {
        return categoryMapper.selectAndTags();
    }

    @Override
    public Category getOneAndTags(Integer id) {
        return categoryMapper.selectOneAndTags(id);
    }

    @Override
    public List<Category> getAndNovelsNum() {
        return categoryMapper.selectAndNovelsNum();
    }

    @Override
    public List<Category> getByExample(CategoryExample example) {
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category getAndTagsByName(String name) {
        Category category = categoryMapper.selectAndTagsByName(name);
//        Category category = new Category();
//        category.setId(1);
//        category.setName("玄幻");
//
//        List<Tag> tags = new ArrayList<>();
//
//        Tag tag1 = new Tag();
//        tag1.setId(3);
//        tag1.setName("异世大陆");
//        tags.add(tag1);
//
//        Tag tag2 = new Tag();
//        tag2.setId(4);
//        tag2.setName("东方玄幻");
//        tags.add(tag2);
//
//        Tag tag3 = new Tag();
//        tag3.setId(5);
//        tag3.setName("王朝争霸");
//        tags.add(tag3);
//
//        Tag tag4 = new Tag();
//        tag4.setId(7);
//        tag4.setName("高武世界");
//        tags.add(tag4);
//
//        category.setTags(tags);

        return category;
    }

    @Override
    public int insert(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int updateById(Category category) {
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public int deleteById(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }
}
