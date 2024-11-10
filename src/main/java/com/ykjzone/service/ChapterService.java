package com.ykjzone.service;

import com.ykjzone.pojo.Chapter;
import com.ykjzone.pojo.ChapterExample;
import com.ykjzone.pojo.Novel;

import java.util.List;

public interface ChapterService {
    public Chapter getChapterById(String id);

    public List<Chapter> getChaptersByNovelId(String id);

    public List<Chapter> getChaptersByExample(ChapterExample example);

    public String getIdByNovelAndNum(Novel novel, int number);

    public void insert(Chapter chapter);

    public void updateByIdSelective(Chapter chapter);

    public void deleteById(String id);

    public int deleteByNovelId(String novel_id);
}
