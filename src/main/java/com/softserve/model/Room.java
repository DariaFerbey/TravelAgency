package com.softserve.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "room_number", unique = true)
    private Integer number;

    @Column(name = "price", unique = true)
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(orphanRemoval = true, mappedBy = "room", fetch = FetchType.EAGER)
    private List<Booking> bookings;


}
