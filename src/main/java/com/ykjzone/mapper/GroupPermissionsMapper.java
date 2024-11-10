package com.ykjzone.mapper;

import com.ykjzone.pojo.GroupPermissions;
import com.ykjzone.pojo.GroupPermissionsExample;

import java.util.List;

public interface GroupPermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GroupPermissions record);

    int insertSelective(GroupPermissions record);

    List<GroupPermissions> selectByExample(GroupPermissionsExample example);

    GroupPermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GroupPermissions record);

    int updateByPrimaryKey(GroupPermissions record);
}