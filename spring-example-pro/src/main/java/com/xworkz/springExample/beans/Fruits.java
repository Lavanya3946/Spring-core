package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Fruits {
    private int id;
    private String fruitName;
    private  int kg;
    private double cost;

}
