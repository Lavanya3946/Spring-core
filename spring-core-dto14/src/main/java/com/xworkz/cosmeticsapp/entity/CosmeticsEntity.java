package com.xworkz.cosmeticsapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cosmetics_table")
@NamedQuery(name = "getByName", query = "select cosmetics_table from CosmeticsEntity cosmetics_table where cosmetics_table.brand=:brand ")
@NamedQuery(name = "getByType", query = "select cosmetics_table from CosmeticsEntity cosmetics_table where cosmetics_table.type=:type ")

@NamedQuery(name = "updateCostByType", query = "update CosmeticsEntity cosmetics_table set cosmetics_table.cost=:cost where cosmetics_table.type=:type ")

public class CosmeticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "type")
    private String type;
    @Column(name = "cost")
    private Integer cost;
}
