package com.xworkz.DIapp.bean;


import com.xworkz.DIapp.address.Address;
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

public class Patient {
    @Value("1")
    private int id;

    @Value("kavya")
    private String name;

    @Value("34")
    private int age;

    @Value("fever")
    private String disease;

    @Autowired
    private Address address;
}
