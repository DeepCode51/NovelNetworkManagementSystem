package com.ykjzone.service;

import com.ykjzone.pojo.Tag;
import com.ykjzone.pojo.TagExample;

import java.util.List;

public interface TagService {
    public Tag getById(Integer id);

    public Tag getByName(String name);

    public List<Tag> getByExample(TagExample example);

    public List<Tag> getByCategoryId(Integer category_id);

    public List<Tag> getNullCategory();

    public int insert(Tag tag);

    public int update(Tag tag);

    public int delete(Integer id);
}
