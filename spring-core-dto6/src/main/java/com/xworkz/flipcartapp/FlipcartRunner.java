package com.xworkz.flipcartapp;

import com.xworkz.flipcartapp.config.SpringFlipcartConfiguration;
import com.xworkz.flipcartapp.dto.FlipCartDto;
import com.xworkz.flipcartapp.service.FlipCartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FlipcartRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringFlipcartConfiguration.class);
        FlipCartService flipCartService=applicationContext.getBean(FlipCartService.class);

        FlipCartDto flipCartDto = new FlipCartDto();
        flipCartDto.setProductName("dress");
        flipCartDto.setCost(900);
        flipCartService.validateAndSave(flipCartDto);

        flipCartService.getById(2);
        System.out.println(flipCartService);

        flipCartService.getByName("pods");
        System.out.println(flipCartService);

        flipCartService.updateCostByName("pods", 230);
        System.out.println(flipCartService);

        flipCartService.removeById(2);
        System.out.println(flipCartService);
    }
}
