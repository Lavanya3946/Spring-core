package com.xworkz.Bataapp;

import com.xworkz.Bataapp.config.SpringBataConfig;
import com.xworkz.Bataapp.dto.BataDto;
import com.xworkz.Bataapp.service.BataService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BataRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBataConfig.class);
        BataService bataService = applicationContext.getBean(BataService.class);
        BataDto bataDto = new BataDto();
        bataDto.setType("sandels");
        bataDto.setPrice(550.0);
        bataService.validateAndSave(bataDto);

        bataService.getById(1);
        System.out.println(bataService);

        bataService.getByType("sandels");
        System.out.println(bataService);


        bataService.updatePriceByType(990.0, "sandels");
        System.out.println(bataService);

        bataService.removeById(2);
        System.out.println(bataService);
    }
}
