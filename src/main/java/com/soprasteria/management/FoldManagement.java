package com.soprasteria.management;

import com.soprasteria.NameCardEnum;
import com.soprasteria.model.Card;

import java.util.List;

//@RestController
//@RequestMapping("/")
public class FoldManagement {

    public Card selectWinner(List<Card> cards) {
        Card winnerCard = cards.get(0);

        if (krakenAfterBaleine(cards)
                || (!krakenAfterBaleine(cards) && cardIsPresent(cards, NameCardEnum.Kraken.name()) && !cardIsPresent(cards, NameCardEnum.Baleine.name()))
                || allEchapeOrBaleine(cards)) {
            winnerCard = null;
        } else if (cardIsPresent(cards, NameCardEnum.Baleine.name())) {
            winnerCard = atoutOrColorWinnerCard(cards, winnerCard);
        } else if (cardIsPresent(cards, NameCardEnum.SkullKing.name()) && !cardIsPresent(cards, NameCardEnum.Sirene.name())) {
            winnerCard = winnerCardType(cards, NameCardEnum.SkullKing.name());
        } else if (cardIsPresent(cards, NameCardEnum.Pirate.name()) && !cardIsPresent(cards, NameCardEnum.SkullKing.name())) {
            winnerCard = winnerCardType(cards, NameCardEnum.Pirate.name());
        } else if (cardIsPresent(cards, NameCardEnum.Sirene.name())) {
            winnerCard = winnerCardType(cards, NameCardEnum.Sirene.name());
        } else if (cardIsPresent(cards, NameCardEnum.Atout.name())) {
            winnerCard = winnerCardType(cards, NameCardEnum.Atout.name());
            winnerCard = atoutOrColorWinnerCard(cards, winnerCard);
        } else {
            winnerCard = atoutOrColorWinnerCard(cards, winnerCard);
        }
        return winnerCard;
    }

    private boolean krakenAfterBaleine(List<Card> cards) {
        if (cardIsPresent(cards, NameCardEnum.Kraken.name()) && (cardIsPresent(cards, NameCardEnum.Baleine.name()))) {
            return cards.indexOf(new Card(NameCardEnum.Kraken.name(), 0)) > cards.indexOf(new Card(NameCardEnum.Baleine.name(), 0));
        }
        return false;
    }

    private boolean allEchapeOrBaleine(List<Card> cards) {
        return cards.stream().filter(c -> c.getName().equals(NameCardEnum.Echape.name())).count()
                + cards.stream().filter(c -> c.getName().equals(NameCardEnum.Baleine.name())).count() == cards.size();
    }

    private boolean cardIsPresent(List<Card> cards, String nameCard) {
        return cards.stream().anyMatch(c -> c.getName().equals(nameCard));
    }

    private Card winnerCardType(List<Card> cards, String nameCard) {
        return cards.stream().filter(c -> c.getName().equals(nameCard)).findFirst().orElse(null);
    }

    private Card atoutOrColorWinnerCard(List<Card> cards, Card winnerCard) {
        for (Card card : cards) {
            if (cardIsPresent(cards, NameCardEnum.Baleine.name()) && card.getValue() > winnerCard.getValue()) {
                winnerCard = card;
            } else if (!cardIsPresent(cards, NameCardEnum.Baleine.name()) && card.getName().equals(winnerCard.getName()) && card.getValue() >= winnerCard.getValue()) {
                winnerCard = card;
            }
        }
        return winnerCard;
    }
}
