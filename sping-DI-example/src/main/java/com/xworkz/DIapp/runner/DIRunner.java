package com.xworkz.DIapp.runner;


import com.xworkz.DIapp.bean.*;
import com.xworkz.DIapp.congiguartion.SpringDIConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DIRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringDIConfig.class);
        Patient patient = applicationContext.getBean(Patient.class);
        System.out.println(patient);

        Library library = applicationContext.getBean(Library.class);
        System.out.println(library);

        Husband husband = applicationContext.getBean(Husband.class);
        System.out.println(husband);

        Mobile mobile = applicationContext.getBean(Mobile.class);
        System.out.println(mobile);

        Tv tv = applicationContext.getBean(Tv.class);
        System.out.println(tv);

        Laptop laptop = applicationContext.getBean(Laptop.class);
        System.out.println(laptop);

        House house = applicationContext.getBean(House.class);
        System.out.println(house);

        Dish ingredients = applicationContext.getBean(Dish.class);
        System.out.println(ingredients);

        Theater theater = applicationContext.getBean(Theater.class);
        System.out.println(theater);

        Cinema movie = applicationContext.getBean(Cinema.class);
        System.out.println(movie);

        Ecom ecom = applicationContext.getBean(Ecom.class);
        System.out.println(ecom);

        PoliceStation policeStation = applicationContext.getBean(PoliceStation.class);
        System.out.println(policeStation);

        Lenskart lenskart = applicationContext.getBean(Lenskart.class);
        System.out.println(lenskart);

        FancyStore fancyStore = applicationContext.getBean(FancyStore.class);
        System.out.println(fancyStore);

        Hotel hotel = applicationContext.getBean(Hotel.class);
        System.out.println(hotel);

        Forest forest = applicationContext.getBean(Forest.class);
        System.out.println(forest);

        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Toothpaste toothpaste = applicationContext.getBean(Toothpaste.class);
        System.out.println(toothpaste);

        Bank bank = applicationContext.getBean(Bank.class);
        System.out.println(bank);
    }
}
