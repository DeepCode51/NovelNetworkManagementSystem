package com.ykjzone.mapper;

import com.ykjzone.pojo.UserPermissions;
import com.ykjzone.pojo.UserPermissionsExample;

import java.util.List;

public interface UserPermissionsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPermissions record);

    int insertSelective(UserPermissions record);

    List<UserPermissions> selectByExample(UserPermissionsExample example);

    UserPermissions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPermissions record);

    int updateByPrimaryKey(UserPermissions record);
}