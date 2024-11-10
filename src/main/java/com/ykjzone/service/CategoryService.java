package com.ykjzone.service;

import com.ykjzone.pojo.Category;
import com.ykjzone.pojo.CategoryExample;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();

    public List<Category> getCategoriesAndTags();

    public Category getOneAndTags(Integer id);

    public List<Category> getAndNovelsNum();

    public List<Category> getByExample(CategoryExample example);

    public Category getAndTagsByName(String name);

    public int insert(Category category);

    public int updateById(Category category);

    public int deleteById(Integer id);
}
