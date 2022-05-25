package com.mtg.demo.dto;

public class CartasUpdateDto {
    private double newPrice;
	
	private int newQuantity;
	
	private int listId, userId, cardId;
	

    public int getListId() {
		return listId;
	}
    public void setListId(int listId) {
		this.listId = listId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getCardId() {
		return cardId;
	}



	public void setCardId(int cardId) {
		this.cardId = cardId;
	}



	public CartasUpdateDto() {
		
	}

		
	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public int getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(int newQuantity) {
		this.newQuantity = newQuantity;
	}
	
	
}
