package com.xworkz.springExample.runner;

import com.xworkz.springExample.beans.*;
import com.xworkz.springExample.configuration.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllBeanRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        PgBean pgBean = applicationContext.getBean(PgBean.class);
        pgBean.setId(1);
        pgBean.setName("Golden Pg");
        pgBean.setRent(6500.0);
        System.out.println(pgBean);


        BusStop busStop = applicationContext.getBean(BusStop.class);
        busStop.setId(2);
        busStop.setStaringPoint("Navrang");
        busStop.setDestination("Arsikere");
        busStop.setTicketPrice(222);
        System.out.println(busStop);


        RailwayStation railwayStation = applicationContext.getBean(RailwayStation.class);
        railwayStation.setId(3);
        railwayStation.setOnBoarding("SBC");
        railwayStation.setDeparture("tiptur");
        System.out.println(railwayStation);

        Mobile mobile = applicationContext.getBean(Mobile.class);
        mobile.setId(4);
        mobile.setBrand("Redmi Note 13 pro");
        mobile.setCost(25000.0);
        System.out.println(mobile);

        Mall mall = applicationContext.getBean(Mall.class);
        mall.setId(5);
        mall.setName("Lulu mall");
        mall.setLocation("Rajajinagar");
        System.out.println(mall);

        Jewelery jewelery = applicationContext.getBean(Jewelery.class);
        jewelery.setId(6);
        jewelery.setName("ring");
        jewelery.setCost(10000.0);
        System.out.println(jewelery);


        VegetableShop vegetableShop = applicationContext.getBean(VegetableShop.class);
        vegetableShop.setId(7);
        vegetableShop.setShopName("Balaji shop");
        vegetableShop.setVegetableName("onion");
        vegetableShop.setCost(60);
        System.out.println(vegetableShop);


        Fruits fruits = applicationContext.getBean(Fruits.class);
        fruits.setId(8);
        fruits.setFruitName("Apple");
        fruits.setKg(2);
        fruits.setCost(400.0);
        System.out.println(fruits);


        Laptop laptop = applicationContext.getBean(Laptop.class);
        laptop.setId(9);
        laptop.setBrand("HP");
        laptop.setSeries("i3");
        laptop.setCost(40000.00);
        System.out.println(laptop);

        TV tv = applicationContext.getBean(TV.class);
        tv.setId(10);
        tv.setBrand("Sony");
        tv.setCost(50000);
        System.out.println(tv);


        Hospital hospital = applicationContext.getBean(Hospital.class);
        hospital.setId(11);
        hospital.setName("Skin summit");
        hospital.setDoctorName("Pavitra");
        hospital.setSpecialistIn("dermatologist");
        System.out.println(hospital);

        PoliceStation policeStation = applicationContext.getBean(PoliceStation.class);
        policeStation.setId(12);
        policeStation.setLocation("Rajajinagar");
        policeStation.setInspectorName("Sudeep");
        System.out.println(policeStation);

        Company company = applicationContext.getBean(Company.class);
        company.setId(13);
        company.setEmployeeName("Pavitra");
        company.setRole("developer");
        company.setSalary(500000.00);
        System.out.println(company);

        Movie movie = applicationContext.getBean(Movie.class);
        movie.setId(14);
        movie.setName("rajahuli");
        movie.setLanguage("kannada");
        System.out.println(movie);

        Saree saree = applicationContext.getBean(Saree.class);
        saree.setId(15);
        saree.setSareeName("RajaNandini");
        saree.setCost(40000);
        System.out.println(saree);

        Cosmetics cosmetics = applicationContext.getBean(Cosmetics.class);
        cosmetics.setId(16);
        cosmetics.setProductName("Lakme powder compact");
        cosmetics.setCost(180);
        System.out.println(cosmetics);

        College college = applicationContext.getBean(College.class);
        college.setId(17);
        college.setCollegeName("kalpataru first grade science college");
        college.setDepartment("BCA");
        System.out.println(college);

        School school=applicationContext.getBean(School.class);
        school.setId(18);
        school.setName("oxford english high school");
        school.setNoOfStudents(100);
        System.out.println(school);

        WaterBottle waterBottle=applicationContext.getBean(WaterBottle.class);
        waterBottle.setId(19);
        waterBottle.setBrand("Tupper Ware");
        waterBottle.setCost(320);
        System.out.println(waterBottle);

        Actor actor=applicationContext.getBean(Actor.class);
        actor.setId(20);
        actor.setActorName("darshan");
        actor.setLanguage("kannada");
        System.out.println(actor);

        Hotel hotel=applicationContext.getBean(Hotel.class);
        hotel.setId(21);
        hotel.setHotelName("Udupi hotel");
        hotel.setType("veg");
        System.out.println(hotel);

        Flipcart flipcart=applicationContext.getBean(Flipcart.class);
        flipcart.setId(22);
        flipcart.setProductName("ear pods");
        flipcart.setRating(3);
        System.out.println(flipcart);

        Zepto zepto=applicationContext.getBean(Zepto.class);
        zepto.setId(23);
        zepto.setOrders("bingo,krack-jack,snikers");
        zepto.setCost(1000);
        System.out.println(zepto);

        MetroStation metroStation=applicationContext.getBean(MetroStation.class);
        metroStation.setId(24);
        metroStation.setJourneyStart("Rajajinagar");
        metroStation.setDestination("silk institute");
        metroStation.setTicketPrice(30);
        System.out.println(metroStation);

        Sports sports=applicationContext.getBean(Sports.class);
        sports.setId(25);
        sports.setSportName("shuttle-cock");
        sports.setNoOfPlayers(2);
        System.out.println(sports);

    }


}
