package com.soprasteria.management;

import com.soprasteria.NameCardEnum;
import com.soprasteria.model.Card;

import java.util.List;

public class BonusScoreManagement {

    private final FoldManagement foldManagement = new FoldManagement();

    public int countBonus(List<Card> cards) {
        int bonus = 0;
        if (foldManagement.selectWinner(cards) == null) {
            return bonus;
        }

        if (cardType(cards, NameCardEnum.SkullKing.name())) {
            int totalOfPirates = (int) cards.stream().filter(c -> c.getName().equals(NameCardEnum.Pirate.name())).count();
            bonus += 30 * totalOfPirates;
        }

        if (cardType(cards, NameCardEnum.Pirate.name())) {
            int totalOfSirenes = (int) cards.stream().filter(c -> c.getName().equals(NameCardEnum.Sirene.name())).count();
            bonus += 20 * totalOfSirenes;
        }

        if (cardType(cards, NameCardEnum.Sirene.name()) && cards.stream().anyMatch(c -> c.getName().equals(NameCardEnum.SkullKing.name()))) {
            bonus += 40;
        }

        if (cards.stream().anyMatch(c -> c.getName().equals(NameCardEnum.Atout.name()) && c.getValue() == 14)) {
            bonus += 20;
        }

        if (cards.stream().anyMatch(c -> !c.getName().equals(NameCardEnum.Atout.name()) && c.getValue() == 14)) {
            int totalOfColor14 = (int) cards.stream().filter(c -> !c.getName().equals(NameCardEnum.Atout.name()) && c.getValue() == 14).count();
            bonus += 10 * totalOfColor14;
        }
        return bonus;
    }

    private boolean cardType(List<Card> cards, String type) {
        return foldManagement.selectWinner(cards).getName().equals(type);
    }
}
