package com.ykjzone.service.impl;

import com.ykjzone.mapper.UserCollectMapper;
import com.ykjzone.pojo.Novel;
import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserCollect;
import com.ykjzone.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    UserCollectMapper userCollectMapper;

    @Override
    public List<UserCollect> getByUidAndNid(String user_id, String novel_id) {
        return userCollectMapper.selectByUidAndNid(user_id,novel_id);
    }

    @Override
    public int insert(String user_id, String novel_id) {
        return userCollectMapper.insert(user_id, novel_id);
    }

    @Override
    public int delete(String user_id, String novel_id) {
        return userCollectMapper.delete(user_id,novel_id);
    }

    @Override
    public int deleteByNovelId(String novel_id) {
        return userCollectMapper.deleteByNovelId(novel_id);
    }
}
