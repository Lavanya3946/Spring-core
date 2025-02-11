package com.xworkz.DIapp.address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component

public class Shef {
    @Value("15")
    private int id;

    @Value("yograj Batruu")
    private String name;

    @Value("4")
    private int noOfYearWorking;
}
