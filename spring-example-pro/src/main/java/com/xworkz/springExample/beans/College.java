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

public class College {
    private int id;
    private String collegeName;
    private String department;

    @Autowired
    public College(@Value("3") int id, @Value("RT university") String collegeName, @Value("MCA") String department) {
        this.id = id;
        this.collegeName = collegeName;
        this.department = department;
    }


}
