package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Shef;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component

public class Hotel {
    @Value("15")
    private int id;

    @Value("Shivalis hotel")
    private String name;

    @Value("Veg")
    private String type;

    @Autowired
    private Shef shef;
}
