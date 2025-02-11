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

public class MetroStation {
    private int id;
    private String journeyStart;
    private String destination;
    private int ticketPrice;

    @Autowired
    public MetroStation(@Value("13") int id, @Value("silk institue") String journeyStart, @Value("jalahalli") String destination, @Value("75") int ticketPrice) {
        this.id = id;
        this.journeyStart = journeyStart;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }
}
