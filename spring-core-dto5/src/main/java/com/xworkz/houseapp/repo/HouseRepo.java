package com.xworkz.houseapp.repo;

import com.xworkz.houseapp.entity.HouseEntity;

public interface HouseRepo {

    boolean save(HouseEntity houseEntity);
    HouseEntity getById(Integer id);

    Void getByName(String house_name);

    HouseEntity updateHouseNoByName(String house_name,Integer houseNo);

    void removeBYId(Integer id);
}
