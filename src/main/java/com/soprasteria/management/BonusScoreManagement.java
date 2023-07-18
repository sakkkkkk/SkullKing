package com.soprasteria.management;

import com.soprasteria.model.Card;

import java.util.List;

public class BonusScoreManagement {

    private final FoldManagement foldManagement = new FoldManagement();
    public int countBonus(List<Card> cards) {
        int bonus = 0;
        if (foldManagement.selectWinner(cards) == null) {
            return bonus;
        }

        if (foldManagement.selectWinner(cards).getCardType().equals("skullKing")){
            int numberOfPirates = (int) cards.stream().filter(c -> c.getCardType().equals("pirate")).count();
            bonus += 30 * numberOfPirates;
        }

        if (foldManagement.selectWinner(cards).getCardType().equals("pirate")){
            int numberOfSirenes = (int) cards.stream().filter(c -> c.getCardType().equals("sirene")).count();
            bonus += 20 * numberOfSirenes;
        }

        if (foldManagement.selectWinner(cards).getCardType().equals("sirene") && cards.stream().anyMatch(c -> c.getCardType().equals("skullKing"))) {
            bonus += 40;
        }

        if (cards.stream().anyMatch(c -> c.getCardValue() == 14)){
            int numberOf14 = (int) cards.stream().filter(c -> c.getCardValue() == 14).count();
            bonus += 10 * numberOf14;
        }
        return bonus;
    }
}
