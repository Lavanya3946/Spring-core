package com.xworkz.springcoredto3app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "school_table")
@NamedQuery(name = "getByName",query = "select school_table from SchoolEntity school_table where school_table.name=:name")
@NamedQuery(name = "updateLocationByName",query = "update SchoolEntity school_table set school_table.location=:location where school_table.name=:name ")

public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "school_name")
    private String name;
    @Column(name = "location")
    private  String  location;
}
