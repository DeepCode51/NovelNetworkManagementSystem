package com.ykjzone.mapper;

import com.ykjzone.pojo.Tag;
import com.ykjzone.pojo.TagExample;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Integer id);

    Tag selectByName(String name);

    List<Tag> selectByCategoryId(Integer category_id);

    List<Tag> selectNullCategory();

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}