package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Director;
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


public class Cinema {
    @Value("10")
    private int id;

    @Value("LALIHADU")
    private String MovieName;

    @Value("kannada")
    private String language;

    @Autowired
    private Director director;
}
