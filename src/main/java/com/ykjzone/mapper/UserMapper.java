package com.ykjzone.mapper;

import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByTelephone(String telephone);

    User selectByUsername(String username);

    User selectByTelephoneAndPassword(@Param("telephone") String telephone, @Param("password") String password);

    List<User> selectStaffs();
}