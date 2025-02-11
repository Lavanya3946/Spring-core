package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Component

public class Hotel {
    private int id;
    private String hotelName;
    private String type;


    @Autowired
    public Hotel(@Value("9") int id, @Value("Kamath Hotel") String hotelName, @Value("veg") String type) {
        this.id = id;
        this.hotelName = hotelName;
        this.type = type;
    }
}
