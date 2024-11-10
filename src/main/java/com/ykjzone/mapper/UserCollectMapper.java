package com.ykjzone.mapper;

import com.ykjzone.pojo.User;
import com.ykjzone.pojo.UserCollect;
import com.ykjzone.pojo.UserCollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCollectMapper {
    List<UserCollect> selectByUidAndNid(@Param("user_id") String user_id, @Param("novel_id")String novel_id);

    int insert(@Param("user_id") String user_id, @Param("novel_id")String novel_id);

    int delete(@Param("user_id") String user_id, @Param("novel_id")String novel_id);

    int deleteByPrimaryKey(Integer id);

    int deleteByNovelId(String novel_id);

    int insertSelective(UserCollect record);

    List<UserCollect> selectByExample(UserCollectExample example);

    UserCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCollect record);

    int updateByPrimaryKey(UserCollect record);
}