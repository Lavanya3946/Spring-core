package com.xworkz.carapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "car_details")
@NamedQuery(name = "getByBrand", query = "select car_details from CarEntity car_details where car_details.brand=:brand")
@NamedQuery(name = "updateCostByBrand", query = "update CarEntity  car_details set car_details.cost=:cost where car_details.brand=:brand ")

public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "car_brand")
    private String brand;
    @Column(name = "cost")
    private Double cost;
}
