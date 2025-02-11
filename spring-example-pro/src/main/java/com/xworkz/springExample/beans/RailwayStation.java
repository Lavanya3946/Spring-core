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

public class RailwayStation {

    @Value("18")
    private int id;

    @Value("Arsikere")
    private String onBoarding;

    @Value("tumkur")
    private String departure;


}
