package com.xworkz.houseapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class HouseDto {
    private Integer id;
    private String name;
    private String address;
    private Integer houseNo;
}
