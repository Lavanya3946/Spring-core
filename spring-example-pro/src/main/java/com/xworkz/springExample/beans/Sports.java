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

public class Sports {

    @Value("21")
    private int id;

    @Value("cricket")
    private String sportName;

    @Value("11")
    private int noOfPlayers;
}
