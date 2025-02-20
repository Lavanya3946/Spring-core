package com.xworkz.Dmartapp;

import com.xworkz.Dmartapp.config.SpringDmartConfig;
import com.xworkz.Dmartapp.dto.DmartDto;
import com.xworkz.Dmartapp.service.DmartService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DMartRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringDmartConfig.class);
        DmartService dmartService = applicationContext.getBean(DmartService.class);

        DmartDto dmartDto = new DmartDto();
        dmartDto.setLocation("rajajinagar");
        dmartDto.setNoOfEmployees(9);
        dmartService.validateAndSave(dmartDto);

        dmartService.getById(2);
        System.out.println(dmartService);

        dmartService.getByLocation("vijaynagar");
        System.out.println(dmartService);

        dmartService.updateEmployeesByLocation("vijaynagar", 6);
        System.out.println(dmartService);

        dmartService.removeById(1);
        System.out.println(dmartService);


    }
}
