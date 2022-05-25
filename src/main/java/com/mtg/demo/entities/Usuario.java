package com.mtg.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

    private final static long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(nullable = false, length = 60, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "userDono")
	@JsonIgnoreProperties({"userDono"})
	private List<ListaCartas> lists = new ArrayList<>();
	
	private Usuario() {
		
	}
	
	private Usuario(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ListaCartas> getLists() {
		return this.lists;
	}

	public void setLists(List<ListaCartas> lists) {
		this.lists = lists;
	}

}