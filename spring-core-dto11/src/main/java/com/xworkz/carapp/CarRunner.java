package com.xworkz.carapp;

import com.xworkz.carapp.config.SpringCarConfig;
import com.xworkz.carapp.dto.CarDto;
import com.xworkz.carapp.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringCarConfig.class);
        CarService carService = applicationContext.getBean(CarService.class);

        CarDto carDto = new CarDto();
        carDto.setBrand("Kwid");
        carDto.setCost(500000.0);
        carService.validateAndSave(carDto);

        carService.getById(1);
        System.out.println(carService);

        carService.getByBrand("kwid");
        System.out.println(carService);

        carService.updateCostByBrand(700000.0, "kwid");
        System.out.println(carService);

        carService.removeById(2);
        System.out.println(carService);

    }
}
