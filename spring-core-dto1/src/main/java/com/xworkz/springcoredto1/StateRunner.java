package com.xworkz.springcoredto1;

import com.xworkz.springcoredto1.configuration.StateSpringConfiguration;
import com.xworkz.springcoredto1.dto.StateDto;
import com.xworkz.springcoredto1.entity.StateEntity;
import com.xworkz.springcoredto1.service.StateService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StateRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(StateSpringConfiguration.class);
        StateService service=applicationContext.getBean(StateService.class);
//        StateDto stateDto=new StateDto();
//        stateDto.setName("andra pradesh");
//        stateDto.setNoOfPeople(741258788);
//        service.validateAndSave(stateDto);
//
//        service.getById(2);
//        System.out.println(service);


        service.getByName("Tamil Nadu");
        System.out.println(service);

//        service.updateStateNameByNOfPopulation("Tamil Nadu",741258);
//        System.out.println(service);
//
//        service.removeById(2);
//        System.out.println(service);

    }
}
