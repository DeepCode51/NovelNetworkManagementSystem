package com.ykjzone.mapper;

import com.ykjzone.pojo.UserRead;
import com.ykjzone.pojo.UserReadExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserReadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(@Param("user_id") String user_id, @Param("novel_id") String novel_id);

    int insertSelective(UserRead record);

    List<UserRead> select(@Param("user_id") String user_id, @Param("novel_id") String novel_id);

    List<UserRead> selectByExample(UserReadExample example);

    UserRead selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRead record);

    int updateByPrimaryKey(UserRead record);

    int deleteByNovelId(String novel_id);
}