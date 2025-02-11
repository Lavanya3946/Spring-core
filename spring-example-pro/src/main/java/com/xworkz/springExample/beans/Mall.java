package com.xworkz.springExample.beans;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class Mall {
    private int id;
    private String name;
    private String location;

    @Autowired
    public Mall(@Value("12") int id, @Value("Mantri mall") String name, @Value("Bangalore") String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
}
