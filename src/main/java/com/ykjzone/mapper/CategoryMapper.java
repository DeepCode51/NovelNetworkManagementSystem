package com.ykjzone.mapper;

import com.ykjzone.pojo.Category;
import com.ykjzone.pojo.CategoryExample;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectAndTagsByName(String name);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    List<Category> selectAndTags();

    Category selectOneAndTags(Integer id);

    List<Category> selectAndNovelsNum();

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}