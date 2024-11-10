package com.ykjzone.mapper;

import com.ykjzone.pojo.Advertisement;
import com.ykjzone.pojo.AdvertisementExample;

import java.util.List;

public interface AdvertisementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Advertisement record);

    int insertSelective(Advertisement record);

    List<Advertisement> selectByExample(AdvertisementExample example);

    Advertisement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Advertisement record);

    int updateByPrimaryKey(Advertisement record);
}