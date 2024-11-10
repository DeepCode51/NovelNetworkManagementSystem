package com.ykjzone.service;


import com.ykjzone.pojo.Advertisement;

import java.util.List;

public interface AdvertisementService {
    public List<Advertisement> getAdvertisements();

    public int addAdvertisement(Advertisement advertisement);

    public int updateAdvertisement(Advertisement advertisement);

//    public int deleteAdvertisement(Integer id);
}
