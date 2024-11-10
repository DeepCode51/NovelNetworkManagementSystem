package com.ykjzone.service.impl;

import com.ykjzone.mapper.GroupMapper;
import com.ykjzone.pojo.Group;
import com.ykjzone.pojo.GroupExample;
import com.ykjzone.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupMapper groupMapper;

    @Override
    public List<Group> getGroups() {
        List<Group> groups = groupMapper.selectAll();
        return groups;
    }

    @Override
    public List<Group> getByUserId(String user_id) {
        return groupMapper.selectByUserId(user_id);
    }

    @Override
    public List<Group> getInIds(List<Integer> group_ids) {
        GroupExample example = new GroupExample();
        example.createCriteria().andIdIn(group_ids);
        List<Group> groups = groupMapper.selectByExample(example);
        return groups;
    }
}
