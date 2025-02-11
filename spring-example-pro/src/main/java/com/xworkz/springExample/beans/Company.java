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

public class Company {
    private int id;
    private String employeeName;
    private String role;
    private double salary;

    @Autowired
    public Company(@Value("4") int id, @Value("lavanya") String employeeName, @Value("software enginner") String role, @Value("500000.0") double salary) {
        this.id = id;
        this.employeeName = employeeName;
        this.role = role;
        this.salary = salary;
    }
}
