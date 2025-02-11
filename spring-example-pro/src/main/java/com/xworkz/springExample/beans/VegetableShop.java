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

public class VegetableShop {

    @Value("23")
    private int id;

    @Value("raitra santhe")
    private String shopName;

    @Value("carrot")
    private String vegetableName;

    @Value("40")
    private int cost;

}
