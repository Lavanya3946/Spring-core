package com.workz.Zomato;

import com.workz.Zomato.config.SpringZomatoConfig;

import com.workz.Zomato.dto.ZomatoDto;
import com.workz.Zomato.service.ZomatoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ZomatoRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringZomatoConfig.class);
        ZomatoService zomatoService = applicationContext.getBean(ZomatoService.class);
        ZomatoDto zomatoDto = new ZomatoDto();
        zomatoDto.setFoodName("Neer Dosa");
        zomatoDto.setCost(100);
        zomatoService.validateAndSave(zomatoDto);


        zomatoService.getById(1);
        System.out.println(zomatoService);

        zomatoService.getByName("Neer Dosa");
        System.out.println(zomatoService);

        zomatoService.updateCostByName("pizza", 500);
        System.out.println(zomatoService);

        zomatoService.removeById(1);
        System.out.println(zomatoService);

    }
}
