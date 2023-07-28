package com.soprasteria.service.impl;

import com.soprasteria.model.Card;
import com.soprasteria.model.Player;
import com.soprasteria.service.DistributionService;

import java.util.ArrayList;
import java.util.List;

public class DistributionServiceImpl implements DistributionService {

    private final int MAX_NUMBER_OF_PLAYERS = 8;
    private final int MAX_NUMBER_OF_SETS = 10;

    public List<List<Card>> distributeCards(List<Card> skullKingDeck, List<Player> players, int setNumber) {

        List<List<Card>> playersCards = new ArrayList<>();

        if (players.size() == MAX_NUMBER_OF_PLAYERS && setNumber >= MAX_NUMBER_OF_SETS) {
            setNumber = 9;
        }

        for (int setIndex = 0; setIndex < setNumber; setIndex++) {

            for (Player player : players) {
                Card firstCard = skullKingDeck.get(0);

                if (setIndex == 0) {
                    List<Card> cards = new ArrayList<>();
                    cards.add(firstCard);
                    player.setCards(cards);
                    playersCards.add(player.getCards());
                }
                else {
                    playersCards.get(players.indexOf(player)).add(firstCard);
                }

                skullKingDeck.remove(0);
            }
        }

        return playersCards;
    }
}
