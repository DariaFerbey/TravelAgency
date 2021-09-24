package com.softserve.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country_name", unique = true)
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Hotel> hotels;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
