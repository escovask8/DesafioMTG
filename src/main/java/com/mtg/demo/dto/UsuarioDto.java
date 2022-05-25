package com.mtg.demo.dto;

import java.util.List;

public class UsuarioDto {
    private String name;
    private List<ListaDto> listas;

    public UsuarioDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ListaDto> getListas() {
        return this.listas;
    }

    public void setListas(List<ListaDto> listas) {
        this.listas = listas;
    }
    
    

}
