package com.ykjzone.service.impl;

import com.ykjzone.mapper.BannerMapper;
import com.ykjzone.pojo.Banner;
import com.ykjzone.pojo.BannerExample;
import com.ykjzone.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    public List<Banner> getBanners() {
        BannerExample example = new BannerExample();
        example.setOrderByClause("priority");
        List<Banner> banners = bannerMapper.selectByExample(example);
        return banners;
    }

    @Override
    public Banner getById(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addBanner(Banner banner) {
        return bannerMapper.insert(banner);
    }

    @Override
    public int updateBanner(Banner banner) {
        return bannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public int deleteById(Integer id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }
}
