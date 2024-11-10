package com.ykjzone.service.impl;

import com.ykjzone.mapper.UserMapper;
import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserExample;
import com.ykjzone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void login(User user) {
        userMapper.insert(user);
    }

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getByTelephone(String telephone) {
        return userMapper.selectByTelephone(telephone);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User getByTelephoneAndPassword(String telephone, String password) {
        return userMapper.selectByTelephoneAndPassword(telephone, password);
    }

    @Override
    public int updateSelective(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> getStaffs() {
        List<User> users = userMapper.selectStaffs();
        return users;
    }
}
