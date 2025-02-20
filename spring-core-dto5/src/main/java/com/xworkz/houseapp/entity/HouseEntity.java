package com.xworkz.houseapp.entity;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "house_table")
@NamedQuery(name = "getDataByName", query = "select house_table from  HouseEntity house_table where  house_table.name=:name")
@NamedQuery(name = "updateHouseNoByName", query = "update  HouseEntity house_table set house_table.houseNo=:houseNo where house_table.name=:name")

public class HouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "house_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "houseNo")
    private Integer houseNo;
}
