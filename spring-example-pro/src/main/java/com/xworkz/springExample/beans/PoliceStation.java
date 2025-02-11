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

public class PoliceStation {

    @Value("17")
    private int id;

    @Value("Vijaynagar")
    private String location;

    @Value("Sudhananda")
    private String InspectorName;

}
