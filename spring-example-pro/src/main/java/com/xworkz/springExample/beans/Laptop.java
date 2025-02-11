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

public class Laptop {
    private int id;
    private String brand;
    private String series;
    private double cost;

    @Autowired
    public Laptop(@Value("11") int id, @Value("Dell") String brand, @Value("i5") String series, @Value("50000.0") double cost) {
        this.id = id;
        this.brand = brand;
        this.series = series;
        this.cost = cost;
    }
}
