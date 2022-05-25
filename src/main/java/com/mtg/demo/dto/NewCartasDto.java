package com.mtg.demo.dto;

import javax.validation.constraints.NotNull;

import com.mtg.demo.entities.Cartas;

public class NewCartasDto {
    @NotNull(message = "Insira a ID da Lista")
	private Integer listId;
	
	@NotNull(message = "Insira a ID do Usuário")
	private Integer userId;
	
	@NotNull(message = "Não pode ficar em branco")
	private Cartas cartas;
	
	
	public NewCartasDto() {
		
	}


	public Integer getListId() {
		return listId;
	}


	public void setListId(Integer listId) {
		this.listId = listId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Cartas getCartas() {
		return cartas;
	}


	public void setCartas(Cartas cartas) {
		this.cartas = cartas;
	}
	
	
	
}

