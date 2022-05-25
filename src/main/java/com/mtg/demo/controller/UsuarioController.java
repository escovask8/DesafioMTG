package com.mtg.demo.controller;

import com.mtg.demo.entities.Usuario;
import com.mtg.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Usuario usuario){
		
		if(!usuarioRepository.existsByName(usuario.getName())) {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
			
		}else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Name already exist!");
	}

}