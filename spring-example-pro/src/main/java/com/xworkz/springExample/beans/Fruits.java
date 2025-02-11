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
public class Fruits {
    private int id;
    private String fruitName;
    private  int kg;
    private double cost;


    @Autowired
    public Fruits(@Value("7")int id,@Value("orange") String fruitName, @Value("3")int kg,@Value("60.0") double cost) {
        this.id = id;
        this.fruitName = fruitName;
        this.kg = kg;
        this.cost = cost;
    }
}
