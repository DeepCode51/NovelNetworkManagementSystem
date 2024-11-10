package com.ykjzone.service;

import com.ykjzone.pojo.User;

import java.util.List;

public interface UserService {
    public void login(User user);

    public void register(User user);

    public User getById(String id);

    public User getByTelephone(String telephone);

    public User getByUsername(String username);

    public User getByTelephoneAndPassword(String telephone, String password);

    public int updateSelective(User user);

    public List<User> getStaffs();
}
