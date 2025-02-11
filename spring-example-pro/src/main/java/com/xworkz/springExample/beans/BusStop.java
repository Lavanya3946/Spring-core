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

public class BusStop {
    private int id;
    private String staringPoint;
    private String destination;
    private int ticketPrice;

    @Autowired
    public BusStop(@Value("2") int id, @Value("ARSIKERE") String staringPoint, @Value("BANGALORE") String destination, @Value("230") int ticketPrice) {
        this.id = id;
        this.staringPoint = staringPoint;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }

}
