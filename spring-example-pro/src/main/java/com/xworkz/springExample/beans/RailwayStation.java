package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class RailwayStation {
    private  int id;
    private String onBoarding;
    private  String  departure;


}
