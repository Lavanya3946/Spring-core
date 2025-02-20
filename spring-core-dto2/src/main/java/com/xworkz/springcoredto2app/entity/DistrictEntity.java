package com.xworkz.springcoredto2app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "district_table")

@NamedQuery(name="getByName",query = "select district_table from DistrictEntity district_table where district_table.name=:name")
@NamedQuery(name = "updateDataOfTaluksByName",query = "update DistrictEntity district_table set district_table.noOfTaluks=:noOfTaluks where district_table.name=:name ")

public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "district_name")
    private String name;
    @Column(name = "no_Of_Taluks")
    private Integer noOfTaluks;
}
