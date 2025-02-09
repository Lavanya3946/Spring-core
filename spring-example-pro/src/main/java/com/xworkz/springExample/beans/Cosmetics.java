package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component

public class Cosmetics {
    private  int id;
    private  String productName;
    private int cost;
}
