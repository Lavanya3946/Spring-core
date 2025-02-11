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

public class School {

    @Value("20")
    private int id;

    @Value("Cambridge School")
    private String name;

    @Value("500")
    private int NoOfStudents;
}
