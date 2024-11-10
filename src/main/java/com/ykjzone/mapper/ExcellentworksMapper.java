package com.ykjzone.mapper;

import com.ykjzone.pojo.Excellentworks;
import com.ykjzone.pojo.ExcellentworksExample;

import java.util.List;

public interface ExcellentworksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Excellentworks record);

    int insertSelective(Excellentworks record);

    List<Excellentworks> selectByExample(ExcellentworksExample example);

    Excellentworks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Excellentworks record);

    int updateByPrimaryKey(Excellentworks record);
}