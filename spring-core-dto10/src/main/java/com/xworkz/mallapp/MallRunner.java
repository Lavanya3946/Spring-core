package com.xworkz.mallapp;

import com.xworkz.mallapp.config.SpringMallConfig;
import com.xworkz.mallapp.dto.MallDto;
import com.xworkz.mallapp.service.MallService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MallRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringMallConfig.class);
        MallService mallService = applicationContext.getBean(MallService.class);

        MallDto mallDto = new MallDto();
        mallDto.setName("orion mall");
        mallDto.setLocation("banglore");
        mallService.validateAndsave(mallDto);

        mallService.getById(1);
        System.out.println(mallService);

        mallService.getByName("lulu mall");
        System.out.println(mallService);

        mallService.updateLocationByName("yeswanthpur", "orion mall");
        System.out.println(mallService);

        mallService.removeById(2);
        System.out.println(mallService);
    }
}
