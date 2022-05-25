package com.mtg.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cartas")
public class Cartas implements Comparable<Cartas> {

	private static long serialVersionUID = 1L;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Cartas.serialVersionUID = serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 60)
	private String name;

	@Column(nullable = false, length = 60)
	private String edition;

	@Column(nullable = false, length = 60)
	private String language;

	@Column(nullable = false)
	private boolean foil;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private int quantity;

	@ManyToMany(mappedBy = "cartas")
	private List<ListaCartas> listaCartas = new ArrayList<>();

	public Cartas() {

	}

	public Cartas(int id, String name, String edition, String language, boolean foil, Double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.edition = edition;
		this.language = language;
		this.foil = foil;
		this.price = price;
		this.quantity = quantity;
	}

	public List<ListaCartas> getListaCartas() {
		return listaCartas;
	}

	public String getEdition() {
		return edition;
	}

	public int getId() {
		return id;
	}

	public String getLanguage() {
		return language;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public boolean isFoil() {
		return foil;
	}

	public void setListaCartas(List<ListaCartas> listaCartas) {
		this.listaCartas = listaCartas;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public void setFoil(boolean foil) {
		this.foil = foil;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Cartas otherCartas) {

		if (this.price > otherCartas.getPrice())
			return -1;

		if (this.price < otherCartas.getPrice())
			return 1;

		return 0;
	}

}