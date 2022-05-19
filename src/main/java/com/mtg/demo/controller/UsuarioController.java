package com.mtg.demo.controller;

import java.util.List;

import com.mtg.demo.entities.Usuario;
import com.mtg.demo.repositories.UsuarioRepository;

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
@RequestMapping("/usuario")
public class UsuarioController {

    //make controller with post, get, put, delete
    @Autowired
    public UsuarioRepository usuarioRepository;


    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id).get();
    }
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioToUpdate = usuarioRepository.findById(id).get();
        usuarioToUpdate.setNome(usuario.getNome());
        usuarioToUpdate.setEmail(usuario.getEmail());
        return usuarioRepository.save(usuarioToUpdate);
    }
    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}