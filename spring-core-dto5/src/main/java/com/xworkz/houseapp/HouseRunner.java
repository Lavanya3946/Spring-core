package com.xworkz.houseapp;

import com.xworkz.houseapp.config.SpringMobileConfig;
import com.xworkz.houseapp.dto.HouseDto;
import com.xworkz.houseapp.service.HouseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringMobileConfig.class);
        HouseService houseService = applicationContext.getBean(HouseService.class);
        HouseDto houseDto = new HouseDto();
        houseDto.setName("lakshmi nilasa");
        houseDto.setAddress(" tumkur");
        houseDto.setHouseNo(6);
        houseService.validateAndSave(houseDto);

        houseService.getById(2);
        System.out.println(houseService);

        houseService.getByName("lakshmi nilasa");
        System.out.println(houseService);


        houseService.updateHouseNoByName("vani nilasa", 9);
        System.out.println(houseService);

        houseService.removeById(2);
        System.out.println(houseService);
    }
}
