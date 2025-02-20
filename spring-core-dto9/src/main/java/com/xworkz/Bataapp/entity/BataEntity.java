package com.xworkz.Bataapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "bata_table")

@NamedQuery(name = "getByType", query = "select bata_table from  BataEntity bata_table where bata_table.type=:type ")
@NamedQuery(name = "updatePriceByType", query = "update BataEntity bata_table set bata_table.price=:price where bata_table.type=:type")

public class BataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "shoe_type")
    private String type;
    @Column(name = "price")
    private Double price;
}
