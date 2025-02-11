package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class Jewelery {
    private int id;
    private String name;
    private double cost;


    @Autowired
    public Jewelery(@Value("10") int id, @Value("Necklace") String name, @Value("85000.0") double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
}
