package com.softserve.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(of = {"name"})
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country_name", unique = true)
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Hotel> hotels;
}
