package com.soprasteria.management;

import com.soprasteria.model.Card;

import java.util.List;

//@RestController
//@RequestMapping("/")
public class FoldManagement {
//    private final List<String> specialCards = List.of("atout", "sirene", "pirate", "skullKing", "baleine", "kraken", "echap");
    public Card selectWinner(List<Card> cards) {
        Card winnerCard = cards.get(0);
        if (krakenAfterBaleine(cards)
                || (!krakenAfterBaleine(cards) && cardIsPresent(cards, "kraken") && !cardIsPresent(cards, "baleine"))
                || allEchapOrBaleine(cards)) {
            winnerCard = null;
        }
        else if (cardIsPresent(cards, "baleine")) {
            winnerCard = atoutOrColorWinnerCard(cards, winnerCard);
        }
        else if (cardIsPresent(cards, "skullKing") && !cardIsPresent(cards, "sirene")) {
            winnerCard = winnerCardType(cards, "skullKing");
        }
        else if (cardIsPresent(cards, "pirate") && !cardIsPresent(cards, "skullKing")) {
            winnerCard = winnerCardType(cards, "pirate");
        }
        else if (cardIsPresent(cards, "sirene")) {
            winnerCard = winnerCardType(cards, "sirene");
        }
        else if (cardIsPresent(cards, "atout")) {
            winnerCard = winnerCardType(cards, "atout");
            winnerCard = atoutOrColorWinnerCard(cards, winnerCard);
        }
        else {
            winnerCard = atoutOrColorWinnerCard(cards, winnerCard);
        }
        return winnerCard;
    }

    private boolean krakenAfterBaleine(List<Card> cards) {
        if (cardIsPresent(cards, "kraken") && (cardIsPresent(cards, "baleine"))) {
            Card krakenCard = cards.stream().filter(c -> c.getCardType().equals("kraken")).findFirst().orElseThrow();
            Card baleineCard = cards.stream().filter(c -> c.getCardType().equals("baleine")).findFirst().orElseThrow();
            return krakenCard.getCardPosition() > baleineCard.getCardPosition();
        }
        return false;
    }

    private boolean allEchapOrBaleine(List<Card> cards) {
        return cards.stream().filter(c -> c.getCardType().equals("echap")).count()
                + cards.stream().filter(c -> c.getCardType().equals("baleine")).count() == cards.size();
    }
    private boolean cardIsPresent(List<Card> cards, String specialCard) {
        return cards.stream().anyMatch(c -> c.getCardType().equals(specialCard));
    }
    private Card winnerCardType(List<Card> cards, String specialCard) {
        return cards.stream().filter(c -> c.getCardType().equals(specialCard)).findFirst().orElseThrow();
    }
    private Card atoutOrColorWinnerCard(List<Card> cards, Card winnerCard) {
        for (Card card : cards) {
            if (cardIsPresent(cards, "baleine") && card.getCardNumber() > winnerCard.getCardNumber()) {
                winnerCard = card;
            }
            else if (!cardIsPresent(cards, "baleine") && card.getCardType().equals(winnerCard.getCardType()) && card.getCardNumber() >= winnerCard.getCardNumber()) {
                winnerCard = card;
            }
        }
        return winnerCard;
    }
}
