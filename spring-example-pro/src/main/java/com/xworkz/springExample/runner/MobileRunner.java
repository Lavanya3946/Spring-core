package com.xworkz.springExample.runner;

import com.xworkz.springExample.beans.*;
import com.xworkz.springExample.configuration.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MobileRunner {
    public static void main(String[] args) {

        System.out.println("using @Value in above the variable name ");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Mobile mobile = applicationContext.getBean(Mobile.class);
        System.out.println(mobile);

        Movie movie = applicationContext.getBean(Movie.class);
        System.out.println(movie);

        PgBean pgBean = applicationContext.getBean(PgBean.class);
        System.out.println(pgBean);

        PoliceStation policeStation = applicationContext.getBean(PoliceStation.class);
        System.out.println(policeStation);

        RailwayStation railwayStation = applicationContext.getBean(RailwayStation.class);
        System.out.println(railwayStation);

        Saree saree = applicationContext.getBean(Saree.class);
        System.out.println(saree);

        School school = applicationContext.getBean(School.class);
        System.out.println(school);

        Sports sports = applicationContext.getBean(Sports.class);
        System.out.println(sports);

        TV tv = applicationContext.getBean(TV.class);
        System.out.println(tv);

        VegetableShop vegetableShop = applicationContext.getBean(VegetableShop.class);
        System.out.println(vegetableShop);

        WaterBottle waterBottle = applicationContext.getBean(WaterBottle.class);
        System.out.println(waterBottle);

        Zepto zepto = applicationContext.getBean(Zepto.class);
        System.out.println(zepto);
    }
}
