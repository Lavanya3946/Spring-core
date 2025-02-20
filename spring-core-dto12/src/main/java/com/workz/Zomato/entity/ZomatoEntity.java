package com.workz.Zomato.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "zomato_table")
@NamedQuery(name="getByName",query = "select zomato_table from ZomatoEntity zomato_table where zomato_table. foodName= :foodName")
@NamedQuery(name="updateCostByName",query = "update ZomatoEntity zomato_table set zomato_table.cost=:cost where zomato_table.foodName=:foodName")

public class ZomatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="food_name")
    private String foodName;
    @Column(name = "cost")
    private Integer cost;
}
