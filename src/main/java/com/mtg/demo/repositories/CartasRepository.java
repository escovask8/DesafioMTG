package com.mtg.demo.repositories;

import com.mtg.demo.entities.Cartas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CartasRepository extends JpaRepository<Cartas, Integer> {

}
    

