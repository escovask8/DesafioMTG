package com.mtg.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "lista")

public class ListaCartas {
    private static long serialVersionUID = 1L;
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public static void setSerialVersionUID(long serialVersionUID) {
		ListaCartas.serialVersionUID = serialVersionUID;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 60)
	private String listName;
		
	@ManyToMany
	@JoinTable(name = "lists_cartas",
			joinColumns = {@JoinColumn(name = "list_id")},
			inverseJoinColumns = {@JoinColumn(name = "card_id")})
	@JsonIgnoreProperties({"listaCartas"})
	private Set<Cartas> cartas = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties({"lista"})
	private Usuario userDono;

	public ListaCartas() {
		
	}

	public ListaCartas(int id, String listName, Usuario userDono) {
		super();
		this.id = id;
		this.listName = listName;
		this.userDono = userDono;
	}

	public Set<Cartas> getCartas() {
		return cartas;
	}

	public int getId() {
		return id;
	}

	public String getListName() {
		return listName;
	}

	public Usuario getUsuarioDono() {
		return userDono;
	}

	public void setCartas(Set<Cartas> cartas) {
		this.cartas = cartas;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public void setUsuarioDono(Usuario userDono) {
		this.userDono = userDono;
	}
	
	
}

