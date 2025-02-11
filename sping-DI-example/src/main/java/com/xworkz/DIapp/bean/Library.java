package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Book;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component

public class Library {
    @Value("2")
    private int id;

    @Value("Tumkur")
    private String location;

    @Autowired
    private Book book;
}
