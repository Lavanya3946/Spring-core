package com.xworkz.cosmeticsapp;

import com.xworkz.cosmeticsapp.config.SpringCosmeticsConfig;
import com.xworkz.cosmeticsapp.dto.CosmeticsDto;
import com.xworkz.cosmeticsapp.service.CosmeticsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CosmeticsRunner {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringCosmeticsConfig.class);
        CosmeticsService cosmeticsService = applicationContext.getBean(CosmeticsService.class);
        CosmeticsDto cosmeticsDto = new CosmeticsDto();
        cosmeticsDto.setBrand("himalaya");
        cosmeticsDto.setCost(490);
        cosmeticsDto.setType("powder");
        cosmeticsService.validateAndSave(cosmeticsDto);

        cosmeticsService.getById(1);
        System.out.println(cosmeticsService);
        cosmeticsService.getByBrand("himalaya");
        System.out.println(cosmeticsService);
        cosmeticsService.updateCostByType(900,"cream");
        System.out.println(cosmeticsService);

        cosmeticsService.removeById(3);
        System.out.println(cosmeticsService);
    }
}
