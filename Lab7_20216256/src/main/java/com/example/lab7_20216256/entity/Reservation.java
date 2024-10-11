package com.example.lab7_20216256.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "funcionId", nullable = false)
    private Funcion funcion;

    @ManyToOne
    @JoinColumn(name = "roomSeatId", nullable = false)
    private RoomSeat roomSeat;

    @Column(nullable = false)
    private java.sql.Date startDatetime;

    @Column(nullable = false)
    private java.sql.Date endDatetime;
}

