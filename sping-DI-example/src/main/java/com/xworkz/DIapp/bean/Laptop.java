package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Harddisk;
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

public class Laptop {
    @Value("6")
    private int id;

    @Value("Hp")
    private String brand;

    @Value("40000.0")
    private double cost;

    @Autowired
    private Harddisk hardDisk;


}
