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

public class Saree {

    @Value("19")
    private int id;

    @Value("silk saree")
    private String sareeName;

    @Value("5200")
    private int cost;

}
