package com.xworkz.mobileapp.entity;

import lombok.Data;


import javax.persistence.*;


@Entity
@Data
@Table(name = "mobile_table")
@NamedQuery(name = "getByBrand" ,query = "select mobile_table from MobileEntity  where mobile_table.brand=:brand")

public class MobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "mobile_brand")
    private String brand;
    @Column(name = "cost")
    private  Integer cost;
}
