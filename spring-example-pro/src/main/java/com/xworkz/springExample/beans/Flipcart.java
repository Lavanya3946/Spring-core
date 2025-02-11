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

public class Flipcart {
    private int id;
    private String productName;
    private int rating;

    @Autowired
    public Flipcart(@Value("6") int id, @Value("Iron box") String productName, @Value("560") int rating) {
        this.id = id;
        this.productName = productName;
        this.rating = rating;
    }
}
