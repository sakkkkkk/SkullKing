
package com.soprasteria.service.impl;

import com.soprasteria.enums.NameCardEnum;
import com.soprasteria.model.Card;
import com.soprasteria.service.DeckService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckServiceImpl implements DeckService {
    public List<Card> skullKingDeck() {
        List<Card> allCards = new ArrayList<>();

        for (int nameCardEnumIndex = 0; nameCardEnumIndex < NameCardEnum.values().length; nameCardEnumIndex++) {

            if (nameCardEnumIndex < NameCardEnum.Pirate.ordinal()) {
                for (int cardValue = 0; cardValue < NameCardEnum.getNameCard(nameCardEnumIndex).getMultiplicityOfCardEnum(); cardValue++) {
                    allCards.add(new Card(NameCardEnum.getNameCard(nameCardEnumIndex).name(), cardValue));
                }
            }

            else {
                allCards.addAll(
                        Collections.nCopies(NameCardEnum.getNameCard(nameCardEnumIndex).getMultiplicityOfCardEnum(),
                                new Card(NameCardEnum.getNameCard(nameCardEnumIndex).name(), 0)));
            }
        }

        return allCards;
    }
}
