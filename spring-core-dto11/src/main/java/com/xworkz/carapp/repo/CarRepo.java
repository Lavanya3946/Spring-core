package com.xworkz.carapp.repo;


import com.xworkz.carapp.entity.CarEntity;

public interface CarRepo {
    boolean save(CarEntity carEntity);

    CarEntity getById(Integer id);

    void getByBrand(String car_brand);

    CarEntity updateCostByBrand(Double cost, String car_brand);

    CarEntity removeById(Integer id);

}
