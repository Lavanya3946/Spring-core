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

public class Movie {

    @Value("15")
    private int id;

    @Value("paramatma")
    private String name;

    @Value("kannada")
    private String language;
}
