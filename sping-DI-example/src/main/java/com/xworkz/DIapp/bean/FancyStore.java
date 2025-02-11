package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Building;
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


public class FancyStore {
    @Value("14")
    private int id;

    @Value("Rajajinagar")
    private String location;

    @Value("50000")
    private int rent;

    @Autowired
    private Building building;

}
