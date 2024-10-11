package com.example.lab7_20216256.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lab7_20216256.entity.Funcion;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer> {
}
