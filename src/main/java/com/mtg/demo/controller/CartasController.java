package com.mtg.demo.controller;

import java.util.List;

import com.mtg.demo.entities.Cartas;
import com.mtg.demo.repositories.CartasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartasController {

    @Autowired
    public CartasRepository cartasRepository;

    @GetMapping("/cartas")
    public List<Cartas> getAllCartas() {
        return cartasRepository.findAll();
    }
    @GetMapping("/cartas/{id}")
    public Cartas getCartas(Long id) {
        return cartasRepository.findById(id).get();
    }
    @PostMapping("/cartas")
    public Cartas createCartas(Cartas cartas) {
        return cartasRepository.save(cartas);
    }
    @PutMapping("/cartas/{id}")
    public Cartas updateCartas(Long id, Cartas cartas) {
        cartas.setId(id);
        return cartasRepository.save(cartas);
    }
    @DeleteMapping("/cartas/{id}")
    public void deleteCartas(Long id) {
        cartasRepository.deleteById(id);
    }

    
}
