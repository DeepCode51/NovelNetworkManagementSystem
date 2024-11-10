package com.ykjzone.mapper;

import com.ykjzone.pojo.Permission;
import com.ykjzone.pojo.PermissionExample;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectByUserId(String user_id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}