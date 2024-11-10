package com.ykjzone.mapper;

import com.ykjzone.pojo.ContentType;
import com.ykjzone.pojo.ContentTypeExample;

import java.util.List;

public interface ContentTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContentType record);

    int insertSelective(ContentType record);

    List<ContentType> selectByExample(ContentTypeExample example);

    ContentType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContentType record);

    int updateByPrimaryKey(ContentType record);
}