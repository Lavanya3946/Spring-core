package com.xworkz.springcoredto3app;

import com.xworkz.springcoredto3app.configuration.SpringSchoolConfiguration;
import com.xworkz.springcoredto3app.dto.SchoolDto;
import com.xworkz.springcoredto3app.service.SchoolService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SchoolRunner {
    private static String banavasi;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringSchoolConfiguration.class);
        SchoolService schoolService = applicationContext.getBean(SchoolService.class);
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setName("kalpataru school");
        schoolDto.setLocation("tiptur");
        schoolService.validateAndSave(schoolDto);


        schoolService.getById(2);
        System.out.println(schoolService);

        schoolService.getByName("oxford school");
        System.out.println(schoolService);

        schoolService.updateLocationByName("oxford school", "banavasi");
        System.out.println(schoolService);

        schoolService.removeById(2);
        System.out.println(schoolService);
    }
}
