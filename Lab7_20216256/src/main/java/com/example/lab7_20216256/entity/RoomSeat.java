package com.example.lab7_20216256.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "roomseats")
public class RoomSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;

    @Column(nullable = false, length = 2)
    private String seatNumber;

    @Column(nullable = false)
    private boolean isAvailable;
}
