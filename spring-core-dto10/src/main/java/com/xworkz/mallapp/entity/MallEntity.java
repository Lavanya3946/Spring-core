package com.xworkz.mallapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mall_table")
@NamedQuery(name = "getByName", query = "select mall_table from MallEntity mall_table where mall_table.name=:name")
@NamedQuery(name = "updateLocationByName", query = "update MallEntity  mall_table set mall_table.location=:location where mall_table.name=:name")

public class MallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "mall_name")
    private String name;
    @Column(name = "location")
    private String location;
}
