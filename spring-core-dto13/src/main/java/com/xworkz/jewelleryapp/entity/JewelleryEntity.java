package com.xworkz.jewelleryapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "jewellery_table")
@NamedQuery(name = "getByName", query = "select jewellery_table from JewelleryEntity jewellery_table where jewellery_table.name=:name")
@NamedQuery(name = "updateTypeByName", query = "update JewelleryEntity jewellery_table set jewellery_table.type=:type where jewellery_table.name=:name ")

public class JewelleryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
}
