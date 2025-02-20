package com.xworkz.carapp.service;

import com.xworkz.carapp.dto.CarDto;
import com.xworkz.carapp.entity.CarEntity;
import com.xworkz.carapp.repo.CarRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Override
    public boolean validateAndSave(CarDto carDto) {
        boolean SaveCar = false;
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CarDto>> violations = validator.validate(carDto);
        if (!violations.isEmpty()) {
            violations.stream().forEach(error -> System.out.println(error.getMessage()));
        }
        CarEntity carEntity = new CarEntity();
        BeanUtils.copyProperties(carDto, carEntity);
        SaveCar = carRepo.save(carEntity);
        return SaveCar;
    }

    @Override
    public boolean getById(Integer id) {
        CarEntity carEntity = carRepo.getById(id);
        System.out.println(carEntity);
        return false;
    }

    @Override
    public CarEntity getByBrand(String car_brand) {
        carRepo.getByBrand(car_brand);
        return null;
    }

    @Override
    public void updateCostByBrand(Double cost, String car_brand) {
        carRepo.updateCostByBrand(cost, car_brand);
    }

    @Override
    public void removeById(Integer id) {
        carRepo.removeById(id);
    }
}
