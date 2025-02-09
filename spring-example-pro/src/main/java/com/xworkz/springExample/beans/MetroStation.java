package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component

public class MetroStation {
    private  int id;
    private  String journeyStart;
    private  String destination;
    private  int ticketPrice;

}
