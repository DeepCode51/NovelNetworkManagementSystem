package com.ykjzone.service.impl;

import com.ykjzone.mapper.UserReadMapper;
import com.ykjzone.pojo.Novel;
import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserRead;
import com.ykjzone.pojo.UserReadExample;
import com.ykjzone.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadServiceImpl implements ReadService {
    @Autowired
    UserReadMapper userReadMapper;

    @Override
    public List<UserRead> select(User user, Novel novel) {
        return userReadMapper.select(user.getId(), novel.getId());
    }

    @Override
    public int insert(User user, Novel novel) {
        return userReadMapper.insert(user.getId(), novel.getId());
    }

    @Override
    public int deleteByNovelId(String novel_id) {
        return userReadMapper.deleteByNovelId(novel_id);
    }
}
