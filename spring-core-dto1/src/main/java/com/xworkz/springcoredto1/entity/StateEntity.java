package com.xworkz.springcoredto1.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="state_table")
@NamedQuery(name = "getDataByName", query = "select state_table from StateEntity state_table where  state_table.name=:name")
@NamedQuery(name = "updateNoOfPeopleByName", query = "update StateEntity state_table set state_table.name=:name where state_table.noOfPeople=:noOfPeople")


public class StateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "state_name")
    private String name;
    @Column(name = "no_OfPeople")
    private Integer noOfPeople;
}
