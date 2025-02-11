package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Engine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component

public class Car {
    @Value("17")
    private int id;

    @Value("swift")
    private String name;

    @Value("152.4")
    private double horsepower;

    @Autowired
    private Engine engine;
}
