package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class BusStop {
    private int id;
    private String staringPoint;
    private String  destination;
    private int ticketPrice;

}
