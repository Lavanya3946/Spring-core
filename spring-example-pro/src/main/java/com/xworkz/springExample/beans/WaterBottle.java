package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component

public class WaterBottle {

    @Value("24")
    private  int id;

    @Value("Tupper ware")
    private String brand;

    @Value("500")
    private  int cost;

}
