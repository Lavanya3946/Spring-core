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

public class Cosmetics {
    private int id;
    private String productName;
    private int cost;


    @Autowired
    public Cosmetics(@Value("5") int id, @Value("cream") String productName, @Value("300") int cost) {
        this.id = id;
        this.productName = productName;
        this.cost = cost;
    }
}
