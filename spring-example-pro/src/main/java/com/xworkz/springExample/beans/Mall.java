package com.xworkz.springExample.beans;


import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component

public class Mall {
    private  int id;
    private  String name;
    private  String location;

}
