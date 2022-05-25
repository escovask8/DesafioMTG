package com.mtg.demo.repositories;

import com.mtg.demo.entities.ListaCartas;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaCartasRepository extends JpaRepository<ListaCartas, Integer> {

    boolean existsByListName(String listName);
    ListaCartas findByListName(String listName);

}
    

