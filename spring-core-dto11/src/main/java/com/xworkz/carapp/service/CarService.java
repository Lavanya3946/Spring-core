package com.xworkz.carapp.service;

import com.xworkz.carapp.dto.CarDto;
import com.xworkz.carapp.entity.CarEntity;

public interface CarService {
    boolean validateAndSave(CarDto carDto);

    boolean getById(Integer id);

    CarEntity getByBrand(String car_brand);

    void updateCostByBrand(Double cost, String car_brand);

    void removeById(Integer id);
}
