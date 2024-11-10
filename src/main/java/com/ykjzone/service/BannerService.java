package com.ykjzone.service;

import com.ykjzone.pojo.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner> getBanners();

    public Banner getById(Integer id);

    public int addBanner(Banner banner);

    public int updateBanner(Banner banner);

    public int deleteById(Integer id);
}
