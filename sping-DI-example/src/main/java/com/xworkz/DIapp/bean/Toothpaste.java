package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Brush;
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

public class Toothpaste {
    @Value("18")
    private int id;

    @Value("Colgate")
    private String name;

    @Value("20")
    private int cost;

    @Autowired
    private Brush brush;
}
