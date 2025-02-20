package com.xworkz.Dmartapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dmart_table")
@NamedQuery(name = "getBylocation",query = "select dmart_table from DmartEntity dmart_table  where dmart_table.location=:location")
@NamedQuery(name = "updateEmployeesByLocation",query = "update DmartEntity dmart_table set dmart_table.noOfEmployees=:noOfEmployees where dmart_table.location=:location")

public class DmartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "location")
    private String location;
    @Column(name = "no_Of_Employees")
    private Integer noOfEmployees;
}
