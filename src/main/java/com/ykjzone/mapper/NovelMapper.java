package com.ykjzone.mapper;

import com.ykjzone.pojo.Novel;
import com.ykjzone.pojo.NovelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NovelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Novel record);

    int insertSelective(Novel record);

    List<Novel> selectByExampleWithBLOBs(NovelExample example);

    List<Novel> selectByExample(NovelExample example);

    List<Novel> selectManyRelated(NovelExample ex);

    List<Novel> selectReadedNovelsByUserId(@Param("user_id") String user_id, @Param("is_collect") Boolean is_collect);

    List<Novel> selectCollectByUserId(String user_id);

    List<Novel> selectWorksByUserId(String user_id);

    Novel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Novel record);

    int updateByPrimaryKeyWithBLOBs(Novel record);

    int updateByPrimaryKey(Novel record);
}