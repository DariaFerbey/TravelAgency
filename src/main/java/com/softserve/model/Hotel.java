package com.softserve.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hotel_name")
    private String hotelName;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Room> rooms;



}

