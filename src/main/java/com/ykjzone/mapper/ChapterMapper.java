package com.ykjzone.mapper;

import com.ykjzone.pojo.Chapter;
import com.ykjzone.pojo.ChapterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(String id);

    int deleteByNovelId(String novel_id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    List<Chapter> selectByExampleWithBLOBs(ChapterExample example);

    List<Chapter> selectByExample(ChapterExample example);

    Chapter selectByPrimaryKey(String id);

    List<Chapter> selectChaptersByNovelId(String id);

    String selectIdByNovelAndNum(@Param("novel_id") String novel_id, @Param("number") int number);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKeyWithBLOBs(Chapter record);

    int updateByPrimaryKey(Chapter record);
}