package com.soprasteria.managementTest;

import com.soprasteria.management.FoldManagement;
import com.soprasteria.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = FoldManagement.class)
public class FoldManagementTest {

    private final FoldManagement foldManagement = new FoldManagement();

    @Test
    public void color_yellow_request_by_first_card_played_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 5, 1));
        cards.add(1, addToFold("purple", 14, 2));
        cards.add(2, addToFold("green", 5, 3));

        // When
        Card cardColorRequest = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("yellow", cardColorRequest.getCardType());
    }

    @Test
    public void highest_value_yellow_card_against_all_color_yellow_card_request_by_first_card_played_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 5, 1));
        cards.add(1, addToFold("purple", 14, 2));
        cards.add(2, addToFold("green", 5, 3));
        cards.add(3, addToFold("yellow", 10, 4));
        cards.add(4, addToFold("yellow", 9, 5));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("yellow", winnerCard.getCardType());
        Assertions.assertEquals(10, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(3), winnerCard);
    }

    @Test
    public void atout_card_winner_with_atout_first_card_played_against_all_color_cards_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("atout", 6, 1));
        cards.add(1, addToFold("purple", 14, 2));
        cards.add(2, addToFold("yellow", 10, 3));
        cards.add(3, addToFold("green", 5, 4));
        cards.add(4, addToFold("atout", 5, 5));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("atout", winnerCard.getCardType());
        Assertions.assertEquals(6, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(0), winnerCard);
    }
    @Test
    public void highest_value_atout_card_winner_against_all_color_cards_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 5, 1));
        cards.add(1, addToFold("yellow", 14, 2));
        cards.add(2, addToFold("atout", 4, 3));
        cards.add(3, addToFold("green", 5, 4));
        cards.add(4, addToFold("atout", 3, 5));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("atout", winnerCard.getCardType());
        Assertions.assertEquals(4, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(2), winnerCard);
    }

    @Test
    public void first_sirene_card_winner_against_all_color_and_atout_cards_without_pirate_and_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 5, 1));
        cards.add(1, addToFold("sirene", 0, 2));
        cards.add(2, addToFold("atout", 4, 3));
        cards.add(3, addToFold("green", 5, 4));
        cards.add(4, addToFold("atout", 3, 5));
        cards.add(5, addToFold("sirene", 0, 6));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("sirene", winnerCard.getCardType());
        Assertions.assertEquals(0, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(1), winnerCard);
    }

    @Test
    public void first_pirate_card_winner_against_all_cards_without_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 5, 1));
        cards.add(1, addToFold("sirene", 0, 2));
        cards.add(2, addToFold("pirate", 0, 3));
        cards.add(3, addToFold("green", 5, 4));
        cards.add(4, addToFold("atout", 3, 5));
        cards.add(5, addToFold("pirate", 0, 6));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("pirate", winnerCard.getCardType());
        Assertions.assertEquals(0, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(2), winnerCard);
    }

    @Test
    public void skullKing_card_winner_against_all_cards_without_sirene_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 5, 1));
        cards.add(1, addToFold("pirate", 0, 2));
        cards.add(2, addToFold("pirate", 0, 3));
        cards.add(3, addToFold("green", 5, 4));
        cards.add(4, addToFold("atout", 3, 5));
        cards.add(5, addToFold("skullKing", 0, 6));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("skullKing", winnerCard.getCardType());
        Assertions.assertEquals(0, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(5), winnerCard);
    }
    @Test
    public void sirene_card_winner_against_all_cards_with_pirate_and_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 5, 1));
        cards.add(1, addToFold("pirate", 0, 2));
        cards.add(2, addToFold("pirate", 0, 3));
        cards.add(3, addToFold("skullKing", 0, 4));
        cards.add(4, addToFold("atout", 3, 5));
        cards.add(5, addToFold("sirene", 0, 6));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("sirene", winnerCard.getCardType());
        Assertions.assertEquals(0, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(5), winnerCard);
    }
    @Test
    public void highest_value_card_winner_against_all_cards_because_of_baleine_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 10, 1));
        cards.add(1, addToFold("pirate", 0, 2));
        cards.add(2, addToFold("baleine", 0, 3));
        cards.add(3, addToFold("green", 10, 4));
        cards.add(4, addToFold("atout", 3, 5));
        cards.add(5, addToFold("sirene", 0, 6));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("yellow", winnerCard.getCardType());
        Assertions.assertEquals(10, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(0), winnerCard);
    }

    @Test
    public void no_card_winner_because_of_kraken_without_baleine_after_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 10, 1));
        cards.add(1, addToFold("kraken", 0, 2));
        cards.add(2, addToFold("pirate", 0, 3));
        cards.add(3, addToFold("green", 10, 4));
        cards.add(4, addToFold("atout", 3, 5));
        cards.add(5, addToFold("sirene", 0, 6));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertNull(winnerCard);
    }

    @Test
    public void no_card_winner_because_of_all_echape_cards_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("echape", 0, 1));
        cards.add(1, addToFold("echape", 0, 2));
        cards.add(2, addToFold("echape", 0, 3));
        cards.add(3, addToFold("echape", 0, 4));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertNull(winnerCard);
    }

    @Test
    public void no_card_winner_because_of_all_echape_cards_and_baleine_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("echape", 0, 1));
        cards.add(1, addToFold("echape", 0, 2));
        cards.add(2, addToFold("baleine", 0, 3));
        cards.add(3, addToFold("echape", 0, 4));
        cards.add(4, addToFold("echape", 0, 5));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertNull(winnerCard);
    }

    @Test
    public void no_card_winner_because_of_kraken_after_baleine_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 10, 1));
        cards.add(1, addToFold("baleine", 0, 2));
        cards.add(2, addToFold("pirate", 0, 3));
        cards.add(3, addToFold("green", 10, 4));
        cards.add(4, addToFold("atout", 3, 5));
        cards.add(5, addToFold("kraken", 0, 6));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertNull(winnerCard);
    }

    @Test
    public void yellow10_card_winner_because_of_baleine_after_kraken_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, addToFold("yellow", 10, 1));
        cards.add(1, addToFold("kraken", 0, 2));
        cards.add(2, addToFold("pirate", 0, 3));
        cards.add(3, addToFold("green", 10, 4));
        cards.add(4, addToFold("skullKing", 0, 5));
        cards.add(5, addToFold("baleine", 0, 6));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals("yellow", winnerCard.getCardType());
        Assertions.assertEquals(10, winnerCard.getCardValue());
        Assertions.assertEquals(cards.get(0), winnerCard);
    }
    private Card addToFold(String cardType, int cardNumber, int cardPosition) {
        return new Card(cardType, cardNumber, cardPosition);
    }
}
