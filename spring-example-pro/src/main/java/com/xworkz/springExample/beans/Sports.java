package com.xworkz.springExample.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component

public class Sports {
    private int id;
    private  String sportName;
    private  int noOfPlayers;
}
