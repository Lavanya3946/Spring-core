package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Component
public class Hospital {
    private int id;
    private String name;
    private String doctorName;
    private String specialistIn;

    @Autowired
    public Hospital(@Value("8") int id, @Value("Kalpataru hospital") String name, @Value("Kavitha") String doctorName, @Value("dental") String specialistIn) {
        this.id = id;
        this.name = name;
        this.doctorName = doctorName;
        this.specialistIn = specialistIn;
    }
}
