package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Movie;
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

public class Theater {
    @Value("9")
    private int id;

    @Value("navarang theater")
    private String name;

    @Value("navarang")
    private String location;

    @Autowired
    private Movie movie;
}
