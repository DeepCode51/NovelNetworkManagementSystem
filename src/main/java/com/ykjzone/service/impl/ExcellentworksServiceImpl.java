package com.ykjzone.service.impl;

import com.ykjzone.mapper.ExcellentworksMapper;
import com.ykjzone.pojo.Excellentworks;
import com.ykjzone.pojo.ExcellentworksExample;
import com.ykjzone.service.ExcellentworksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcellentworksServiceImpl implements ExcellentworksService {
    @Autowired
    ExcellentworksMapper excellentworksMapper;

    @Override
    public List<Excellentworks> getExcellentworkses() {
        ExcellentworksExample example = new ExcellentworksExample();
        return excellentworksMapper.selectByExample(example);
    }

    @Override
    public int updateExcellentworks(Excellentworks excellentworks) {
        return excellentworksMapper.updateByPrimaryKeySelective(excellentworks);
    }
}
