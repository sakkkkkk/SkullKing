package com.soprasteria.model;

import java.util.List;

public class Fold {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Fold(List<Card> cards) {
        this.cards = cards;
    }
}
