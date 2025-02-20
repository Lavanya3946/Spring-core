package com.xworkz.flipcartapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "flipcart_table")
@NamedQuery(name = "getDataByName", query = "select flipcart_table from FlipCartEntity flipcart_table where  flipcart_table.productName=:productName")
@NamedQuery(name = "updateCostByName", query = "update FlipCartEntity flipcart_table set flipcart_table.cost=:cost where flipcart_table.productName=:productName")

public class FlipCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_Name")
    private String productName;
    @Column(name = "cost")
    private Integer cost;
}
