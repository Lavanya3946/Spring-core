package com.xworkz.mallapp.repo;

import com.xworkz.mallapp.entity.MallEntity;

public interface MallRepo {
    boolean save(MallEntity mallEntity);

    MallEntity getById(Integer id);

    void getByName(String mall_name);

    MallEntity updateLocationByName(String location, String mall_name);

    MallEntity removeById(Integer id);
}
