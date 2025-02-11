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


public class Jeep {
    @Value("12")
    private int id;

    @Value("KA2178")
    private String jeepNumber;
}
