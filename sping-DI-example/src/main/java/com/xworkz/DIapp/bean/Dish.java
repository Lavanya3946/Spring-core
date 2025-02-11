package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Ingredients;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.zip.CheckedOutputStream;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component

public class Dish {
    @Value("8")
    private int id;

    @Value("chitranna")
    private String name;

    @Autowired
    private Ingredients ingredients;

}
