package com.ykjzone.service.impl;

import com.ykjzone.mapper.TagMapper;
import com.ykjzone.pojo.Tag;
import com.ykjzone.pojo.TagExample;
import com.ykjzone.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public Tag getById(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public Tag getByName(String name) {
        return tagMapper.selectByName(name);
    }

    @Override
    public List<Tag> getByExample(TagExample example) {
        return tagMapper.selectByExample(example);
    }

    @Override
    public List<Tag> getByCategoryId(Integer category_id) {
        return tagMapper.selectByCategoryId(category_id);
    }

    @Override
    public List<Tag> getNullCategory() {
        return tagMapper.selectNullCategory();
    }

    @Override
    public int insert(Tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public int update(Tag tag) {
        return tagMapper.updateByPrimaryKeySelective(tag);
    }

    @Override
    public int delete(Integer id) {
        return tagMapper.deleteByPrimaryKey(id);
    }


}
