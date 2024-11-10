package com.ykjzone.service;

import com.ykjzone.pojo.Group;
import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserGroup;

import java.util.List;

public interface UserGroupService {
    int add(User user, Group group);

    List<UserGroup> getByUserId(String user_id);

    int deleteByUser(User user);
}
