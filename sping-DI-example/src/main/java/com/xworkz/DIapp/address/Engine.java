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


public class Engine {
    @Value("17")
    private int id;

    @Value("V8")
    private String type;

    @Value("Petrol")
    private String fuelType;
}
