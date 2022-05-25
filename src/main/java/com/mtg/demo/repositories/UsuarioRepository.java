package com.mtg.demo.repositories;

import com.mtg.demo.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsById(int id);
    boolean existsByName(String name);
    Usuario findByName(String name);

}
    

