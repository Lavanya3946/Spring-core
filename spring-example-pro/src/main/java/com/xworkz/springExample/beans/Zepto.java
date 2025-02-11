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

public class Zepto {

    @Value("25")
    private int id;

    @Value("ORS")
    private String orders;

    @Value("34")
    private int cost;
}
