package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class Mobile {

    @Value("14")
    private int id;

    @Value("Oppo")
    private String brand;

    @Value("45000.0")
    private double cost;

}
