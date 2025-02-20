package com.xworkz.Pgapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pg_table")

@NamedQuery(name = "getDataByName", query = "select pg_table from PgEntity pg_table where  pg_table.pgName=:pgName")
@NamedQuery(name = "updateCostByName", query = "update PgEntity pg_table set pg_table.pgName=:pgName where pg_table.cost=:cost")

public class PgEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pg_name")
    private String pgName;
    @Column(name = "cost")
    private Integer cost;
}
