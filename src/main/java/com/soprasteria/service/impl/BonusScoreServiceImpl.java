package com.soprasteria.service.impl;

import com.soprasteria.enums.NameCardEnum;
import com.soprasteria.model.Card;
import com.soprasteria.service.BonusScoreService;

import java.util.List;

public class BonusScoreServiceImpl implements BonusScoreService {

    private final FoldServiceImpl foldService = new FoldServiceImpl();

    public int countBonus(List<Card> cards) {
        int bonus = 0;

        if (foldService.selectWinner(cards) == null) {
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
        return foldService.selectWinner(cards).getName().equals(type);
    }
}
