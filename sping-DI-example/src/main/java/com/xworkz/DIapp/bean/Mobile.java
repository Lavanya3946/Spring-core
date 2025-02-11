package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Sim;
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

public class Mobile {
    @Value("4")
    private int id;

    @Value("vivo")
    private String brand;

    @Value("52000")
    private int cost;

    @Autowired
    private Sim sim;

}
