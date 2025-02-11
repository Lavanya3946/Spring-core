package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Wife;
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

public class Husband {
    @Value("RAMA")
    private String name;

    @Value("56")
    private int age;

    @Value("Bcom")
    private String qualification;

    @Autowired
    private Wife wife;
}
