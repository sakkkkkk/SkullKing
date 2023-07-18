package com.soprasteria.model;

public class Card {
    private String cardType;
    private int cardValue;
    private int cardPosition;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getCardPosition() {
        return cardPosition;
    }

    public void setCardPosition(int cardPosition) {
        this.cardPosition = cardPosition;
    }


    public Card(String type, int number, int position) {
        this.cardType = type;
        this.cardValue = number;
        this.cardPosition = position;
    }
}