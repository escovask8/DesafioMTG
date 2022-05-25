package com.mtg.demo.controller;

import java.util.List;



import com.mtg.demo.dto.CartasUpdateDto;
import com.mtg.demo.dto.DeleteCartasDto;
import com.mtg.demo.dto.ListaDto;
import com.mtg.demo.dto.NewCartasDto;
import com.mtg.demo.dto.NewListaCartas;
import com.mtg.demo.services.ListaCartasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/lista")
public class CartasController {

    @Autowired
    private ListaCartasService service;

    @PostMapping
	public ResponseEntity<Object> save(@RequestBody NewListaCartas newListaCartas){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newListaCartas));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<ListaDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}
	
	@GetMapping("/{listname}")
	public ResponseEntity<Object> findByListName(@PathVariable("listname") String listName){
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(service.findByListName(listName));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCard(@Valid @RequestBody NewCartasDto newCartas){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.addCartas(newCartas.getListId(), newCartas.getUserId(), newCartas.getCartas()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/remove")
	public ResponseEntity<Object> removeCard(@RequestBody DeleteCartasDto deleteCartas){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.removeCartas(deleteCartas.getListId(), deleteCartas.getUserId(), deleteCartas.getCardId()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<Object> updateCard(@RequestBody CartasUpdateDto updateCartas){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.updateCartas(updateCartas));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}