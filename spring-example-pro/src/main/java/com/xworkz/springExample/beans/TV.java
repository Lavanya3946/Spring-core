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

public class TV {

    @Value("22")
    private int id;

    @Value("universal")
    private String brand;

    @Value("45000")
    private int cost;
}
