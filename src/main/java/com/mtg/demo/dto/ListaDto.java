package com.mtg.demo.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mtg.demo.entities.Cartas;
import com.mtg.demo.entities.ListaCartas;

public class ListaDto {
	
	private int id;
	
	private String ListName;
	
	private String userName;
	
	@JsonIgnoreProperties({"listaCartas"})
	private Set<Cartas> cartas;
	
	
	public ListaDto() {
		
	}
	
	public static ListaDto ToDto(ListaCartas listaCartas) {
		
		ListaDto listaDto = new ListaDto();
		
		listaDto = new ListaDto();
		listaDto.setId(listaCartas.getId());
		listaDto.setListName(listaCartas.getListName());
		listaDto.setUserName(listaCartas.getUsuarioDono().getName());
		listaDto.setCartass(listaCartas.getCartas());
		
		return listaDto;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return ListName;
	}

	public void setListName(String listName) {
		ListName = listName;
	}

	public Set<Cartas> getCartass() {
		return cartas;
	}

	public void setCartass(Set<Cartas> cartas) {
		this.cartas = cartas;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}