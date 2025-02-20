package com.xworkz.mobileapp;

import com.xworkz.mobileapp.configuration.SpringMobileConfig;
import com.xworkz.mobileapp.dto.MobileDto;
import com.xworkz.mobileapp.entity.MobileEntity;
import com.xworkz.mobileapp.service.MobileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MobileRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringMobileConfig.class);
        MobileService mobileService=applicationContext.getBean(MobileService.class);
        MobileDto mobileDto=new MobileDto();
        mobileDto.setBrand("oppo");
        mobileDto.setCost(23000);
//        mobileService.validateAndSave(mobileDto);
//        mobileService.getById(1);
//        System.out.println(mobileService);

//        mobileService.getByName("vivo");
//        System.out.println(mobileService);
    }
}
