package com.xworkz.jewelleryapp;

import com.xworkz.jewelleryapp.config.SpringJewelleryConfig;
import com.xworkz.jewelleryapp.dto.JewelleryDto;
import com.xworkz.jewelleryapp.service.JewelleryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JewelleryRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringJewelleryConfig.class);
        JewelleryService jewelleryService = applicationContext.getBean(JewelleryService.class);
        JewelleryDto jewelleryDto = new JewelleryDto();
        jewelleryDto.setName("sai gold palace");
        jewelleryDto.setType("necklace");
        jewelleryService.validateAndSave(jewelleryDto);

        jewelleryService.getById(1);
        System.out.println(jewelleryService);

        jewelleryService.getByName("sai gold palace");
        System.out.println(jewelleryService);

        jewelleryService.updateTypeByName("ring", "sai gold palace");
        System.out.println(jewelleryService);
        jewelleryService.removeById(2);
        System.out.println(jewelleryService);
    }
}
