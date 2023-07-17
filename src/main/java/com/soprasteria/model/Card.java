package com.soprasteria.model;

public class Card {
    private String cardType;
    private int cardNumber;
    private int cardPosition;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardPosition() {
        return cardPosition;
    }

    public void setCardPosition(int cardPosition) {
        this.cardPosition = cardPosition;
    }


    public Card(String type, int number, int position) {
        this.cardType = type;
        this.cardNumber = number;
        this.cardPosition = position;
    }
}