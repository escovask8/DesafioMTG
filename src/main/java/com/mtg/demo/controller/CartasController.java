package com.mtg.demo.controller;

import java.util.List;

import com.mtg.demo.entities.Cartas;
import com.mtg.demo.repositories.CartasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartas")
public class CartasController {

    @Autowired
    public CartasRepository cartasRepository;

    @GetMapping
    public List<Cartas> getAllCartas() {
        return cartasRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cartas getCartas(@PathVariable Long id) {
        return cartasRepository.findById(id).get();
    }

    @PostMapping
    public Cartas createCartas(@RequestBody Cartas cartas) {
        return cartasRepository.save(cartas);
    }

    @PutMapping("/{id}")
    public Cartas updateCartas(@PathVariable Long id, @RequestBody Cartas cartas) {
        Cartas cartasToUpdate = cartasRepository.findById(id).get();
        cartasToUpdate.setNome(cartas.getNome());
        cartasToUpdate.setEdicao(cartas.getEdicao());
        cartasToUpdate.setRaridade(cartas.getRaridade());
        return cartasRepository.save(cartasToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteCartas(@PathVariable Long id) {
        cartasRepository.deleteById(id);
    }
}
