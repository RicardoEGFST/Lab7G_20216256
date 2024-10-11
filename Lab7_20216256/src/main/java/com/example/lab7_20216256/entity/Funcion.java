package com.example.lab7_20216256.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "funciones")
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "obraId", nullable = false)
    private Obra obra;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;

    @Column(nullable = false)
    private java.sql.Date funcionDate;

    @Column(nullable = false)
    private int availableSeats;

    @OneToMany(mappedBy = "funcion")
    private List<Reservation> reservations;
}
