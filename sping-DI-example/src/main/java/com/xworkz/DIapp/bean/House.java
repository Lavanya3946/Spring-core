package com.xworkz.DIapp.bean;

import com.xworkz.DIapp.address.Room;
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


public class House {
    @Value("7")
    private int id;

    @Value("vani nilasa")
    private String name;

    @Value("dubai")
    private String location;

    @Autowired
    private Room room;

}
