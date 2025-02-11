package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Specs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.omg.CORBA.NO_IMPLEMENT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Component


public class Lenskart {
    @Value("13")
    private int id;

    @Value("vijaynagar")
    private String location;

    @Autowired
    private Specs specs;

}
