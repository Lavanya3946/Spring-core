package com.xworkz.springcoredto2app;

import com.xworkz.springcoredto2app.configuration.SpringDistrictConfig;
import com.xworkz.springcoredto2app.dto.DistrictDto;
import com.xworkz.springcoredto2app.service.DistrictService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DistrictRunner {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringDistrictConfig.class);
        DistrictService districtService = applicationContext.getBean(DistrictService.class);
        DistrictDto districtDto = new DistrictDto();
        districtDto.setName("Tunkur");
        districtDto.setNoOfTaluks(56);
        districtService.validateAndSave(districtDto);

        districtService.getById(2);
        System.out.println(districtService);

        districtService.getByName("hassan");
        System.out.println(districtService);

        districtService.updateTalukByName("hassan",34);
        System.out.println(districtService);

        districtService.removeById(2);
        System.out.println(districtService);

    }
}

