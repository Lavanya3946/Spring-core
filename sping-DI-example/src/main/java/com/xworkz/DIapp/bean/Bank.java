package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Account;
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

public class Bank {
    @Value("19")
    private int id;

    @Value("Canara")
    private String name;

    @Value("kengeri")
    private String location;

    @Autowired
    private Account account;
}
