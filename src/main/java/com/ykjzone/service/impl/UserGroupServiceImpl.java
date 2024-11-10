package com.ykjzone.service.impl;

import com.ykjzone.mapper.UserGroupMapper;
import com.ykjzone.pojo.Group;
import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserGroup;
import com.ykjzone.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService {
    @Autowired
    UserGroupMapper userGroupMapper;

    @Override
    public int add(User user, Group group) {
        UserGroup userGroup = new UserGroup();
        userGroup.setUser(user);
        userGroup.setGroup(group);
        return userGroupMapper.insert(userGroup);
    }

    @Override
    public List<UserGroup> getByUserId(String user_id) {
        return userGroupMapper.selectByUserId(user_id);
    }



    @Override
    public int deleteByUser(User user) {
        return userGroupMapper.deleteByUserId(user.getId());
    }
}
