package com.xworkz.DIapp.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component

public class Director {
    @Value("10")
    private int id;

    @Value("prem")
    private String directorName;

    @Value("253100.0")
    private double budget;
}
