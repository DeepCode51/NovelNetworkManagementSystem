package com.ykjzone.mapper;

import com.ykjzone.pojo.Banner;
import com.ykjzone.pojo.BannerExample;

import java.util.List;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}