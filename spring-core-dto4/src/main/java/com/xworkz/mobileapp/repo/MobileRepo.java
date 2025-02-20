package com.xworkz.mobileapp.repo;

import com.xworkz.mobileapp.entity.MobileEntity;

public interface MobileRepo {
    boolean save(MobileEntity mobileEntity);
    MobileEntity getById(Integer id);
    void getByName(String mobile_brand);

}
