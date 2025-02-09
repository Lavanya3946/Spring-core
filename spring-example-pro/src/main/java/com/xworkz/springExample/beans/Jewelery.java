package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class Jewelery {
    private int id;
    private  String name;
    private   double cost;
}
