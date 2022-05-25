package com.mtg.demo.services;

import com.mtg.demo.entities.Cartas;
import com.mtg.demo.repositories.CartasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartasService {

    @Autowired
    private CartasRepository repository;

    public Cartas save(Cartas cartas) throws Exception {
        if (cartas.getLanguage().equals("pt-br") || cartas.getLanguage().equals("en")
                || cartas.getLanguage().equals("jp")) {
            return repository.save(cartas);
        } else
            throw new Exception("Linguagem não existe!");

    }
}
