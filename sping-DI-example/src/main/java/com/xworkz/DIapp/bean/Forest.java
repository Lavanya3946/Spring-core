package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Animals;
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

public class Forest {
    @Value("16")
    private int id;

    @Value("Taiga")
    private String name;

    @Value("canada")
    private String location;

    @Autowired
    private Animals animals;
}
