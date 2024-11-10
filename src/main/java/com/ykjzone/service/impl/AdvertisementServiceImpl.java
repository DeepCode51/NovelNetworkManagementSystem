package com.ykjzone.service.impl;

import com.ykjzone.mapper.AdvertisementMapper;
import com.ykjzone.pojo.Advertisement;
import com.ykjzone.pojo.AdvertisementExample;
import com.ykjzone.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    AdvertisementMapper advertisementMapper;

    public List<Advertisement> getAdvertisements() {
        AdvertisementExample example = new AdvertisementExample();
        List<Advertisement> ads = advertisementMapper.selectByExample(example);
        return ads;
    }

    @Override
    public int addAdvertisement(Advertisement advertisement) {
        return advertisementMapper.insert(advertisement);
    }

    @Override
    public int updateAdvertisement(Advertisement advertisement) {
        return advertisementMapper.updateByPrimaryKeySelective(advertisement);
    }

//    @Override
//    public int deleteAdvertisement(Integer id) {
//        return deleteAdvertisement(id);
//    }
}
