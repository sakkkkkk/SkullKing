package com.soprasteria.service.impl;

import com.soprasteria.model.Card;
import com.soprasteria.model.Player;
import com.soprasteria.service.DistributionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.addAll;
import static java.util.Collections.shuffle;

public class DistributionServiceImpl implements DistributionService {
    private final DeckServiceImpl deck = new DeckServiceImpl();
    public List<Card> distributeCards(List<Player> players, int setNumber) {
        List<Card> deckGame = deck.skullKingDeck();
        Collections.shuffle(deckGame);

        for (int set = 0; set < setNumber; set++) {
            for (Player player : players) {
                List<Card> cards = new ArrayList<>();
                cards.add(deckGame.get());
                player.setCards(cards);
            }
        }
        return ;
    }
}
