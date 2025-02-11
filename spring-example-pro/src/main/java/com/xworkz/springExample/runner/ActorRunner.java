package com.xworkz.springExample.runner;

import com.xworkz.springExample.beans.*;
import com.xworkz.springExample.configuration.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ActorRunner {
    public static void main(String[] args) {
        System.out.println("using @Value in above the  parametrised constructor  ");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Actor actor = applicationContext.getBean(Actor.class);
        System.out.println(actor);

        BusStop busStop = applicationContext.getBean(BusStop.class);
        System.out.println(busStop);

        College college = applicationContext.getBean(College.class);
        System.out.println(college);

        Company company = applicationContext.getBean(Company.class);
        System.out.println(company);

        Cosmetics cosmetics = applicationContext.getBean(Cosmetics.class);
        System.out.println(cosmetics);

        Flipcart flipcart = applicationContext.getBean(Flipcart.class);
        System.out.println(flipcart);


        Fruits fruits = applicationContext.getBean(Fruits.class);
        System.out.println(fruits);

        Hospital hospital = applicationContext.getBean(Hospital.class);
        System.out.println(hospital);

        Hotel hotel = applicationContext.getBean(Hotel.class);
        System.out.println(hotel);

        Jewelery jewelery = applicationContext.getBean(Jewelery.class);
        System.out.println(jewelery);

        Laptop laptop = applicationContext.getBean(Laptop.class);
        System.out.println(laptop);

        Mall mall = applicationContext.getBean(Mall.class);
        System.out.println(mall);

        MetroStation metroStation = applicationContext.getBean(MetroStation.class);
        System.out.println(metroStation);
    }
}
