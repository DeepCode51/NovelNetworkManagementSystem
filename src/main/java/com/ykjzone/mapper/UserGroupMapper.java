package com.ykjzone.mapper;

import com.ykjzone.pojo.UserGroup;
import com.ykjzone.pojo.UserGroupExample;

import java.util.List;

public interface UserGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByUserId(String user_id);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    List<UserGroup> selectByExample(UserGroupExample example);

    UserGroup selectByPrimaryKey(Integer id);

    List<UserGroup> selectByUserId(String user_id);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}