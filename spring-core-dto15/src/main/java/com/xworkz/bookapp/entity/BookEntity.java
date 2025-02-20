package com.xworkz.bookapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="book_table")
@NamedQuery(name = "getByName",query = "select book_table from BookEntity  book_table where book_table.name=:name")
@NamedQuery(name="updateCostByName",query = "update BookEntity book_table set book_table.cost=:cost where book_table.name=:name")


public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(name = "book_name")
    private String name;
    @Column(name = "cost")
    private Integer cost;
}
