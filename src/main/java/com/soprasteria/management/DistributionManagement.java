
package com.soprasteria.management;

import com.soprasteria.model.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistributionManagement {
    public List<Card> distributeCards() {
        List<Card> allCards = new ArrayList<>();
        List<String> cardTypes = Arrays.asList("yellow", "purple", "green", "atout");
        for (String cardType : cardTypes) {
            for (int cardValue = 1; cardValue < 15; cardValue++) {
                allCards.add(new Card(cardType, cardValue));
            }
        }
        allCards.add(new Card("skullKing", 0));
        allCards.add(new Card("baleine", 0));
        allCards.add(new Card("kraken", 0));
        for (int pirate = 1; pirate < 7; pirate++) {
            allCards.add(new Card("pirate", 0));
        }
        for (int pirate = 1; pirate < 8; pirate++) {
            allCards.add(new Card("pirate", 0));
        }


        return allCards;
    }
}
