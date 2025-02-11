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

public class Building {
    @Value("14")
    private int id;

    @Value("DAMODAR")
    private String name;

    @Value("2")
    private int noOfFloors;
}
