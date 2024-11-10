package com.ykjzone.service;

import com.ykjzone.pojo.Group;

import java.util.List;

public interface GroupService {
    List<Group> getGroups();

    List<Group> getByUserId(String user_id);

    List<Group> getInIds(List<Integer> group_ids);
}
