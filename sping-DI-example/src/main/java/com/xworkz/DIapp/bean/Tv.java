package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Stand;
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

public class Tv {
    @Value("5")
    private int id;

    @Value("Sony")
    private String tvName;

    @Value("450000.0")
    private double cost;

    @Autowired
    private Stand stand;
}
