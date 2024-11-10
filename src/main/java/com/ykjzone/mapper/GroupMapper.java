package com.ykjzone.mapper;

import com.ykjzone.pojo.Group;
import com.ykjzone.pojo.GroupExample;

import java.util.List;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(Integer id);

    List<Group> selectByUserId(String user_id);

    List<Group> selectAll();

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}