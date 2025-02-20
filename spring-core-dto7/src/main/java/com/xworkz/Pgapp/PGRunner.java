package com.xworkz.Pgapp;

import com.xworkz.Pgapp.configuration.SpringPGConfig;
import com.xworkz.Pgapp.dto.PgDto;
import com.xworkz.Pgapp.service.PgService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PGRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringPGConfig.class);
        PgService pgService=applicationContext.getBean(PgService.class);

        PgDto pgDto = new PgDto();
        pgDto.setPgName("kushi pg");
        pgDto.setCost(7000);
        pgService.validateAndSave(pgDto);

        pgService.getById(2);
        System.out.println(pgService);

        pgService.getByName("kushi pg");
        System.out.println(pgService);

        pgService.updateCostByName("renuka pg", 7000);
        System.out.println(pgService);

        pgService.removeById(2);
        System.out.println(pgService);
    }
}
