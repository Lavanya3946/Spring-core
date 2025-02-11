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

public class PgBean {

    @Value("16")
    private int id;

    @Value("Kushi PG")
    private String name;

    @Value("7000.0")
    private double rent;
}
