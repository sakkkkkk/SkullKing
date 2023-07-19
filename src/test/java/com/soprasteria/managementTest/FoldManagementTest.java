package com.soprasteria.managementTest;

import com.soprasteria.NameCardEnum;
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
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Green.name(), 5));

        // When
        Card cardColorRequest = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Yellow.name(), cardColorRequest.getName());
    }

    @Test
    public void highest_value_yellow_card_against_all_color_yellow_card_request_by_first_card_played_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Green.name(), 5));
        cards.add(3, new Card(NameCardEnum.Yellow.name(), 10));
        cards.add(4, new Card(NameCardEnum.Yellow.name(), 9));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Yellow.name(), winnerCard.getName());
        Assertions.assertEquals(10, winnerCard.getValue());
        Assertions.assertEquals(cards.get(3), winnerCard);
    }

    @Test
    public void atout_card_winner_with_atout_first_card_played_against_all_color_cards_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Atout.name(), 6));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Yellow.name(), 10));
        cards.add(3, new Card(NameCardEnum.Green.name(), 5));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 5));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Atout.name(), winnerCard.getName());
        Assertions.assertEquals(6, winnerCard.getValue());
        Assertions.assertEquals(cards.get(0), winnerCard);
    }
    @Test
    public void highest_value_atout_card_winner_against_all_color_cards_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Yellow.name(), 14));
        cards.add(2, new Card(NameCardEnum.Atout.name(), 4));
        cards.add(3, new Card(NameCardEnum.Green.name(), 5));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Atout.name(), winnerCard.getName());
        Assertions.assertEquals(4, winnerCard.getValue());
        Assertions.assertEquals(cards.get(2), winnerCard);
    }

    @Test
    public void first_sirene_card_winner_against_all_color_and_atout_cards_without_pirate_and_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Sirene.name(), 0));
        cards.add(2, new Card(NameCardEnum.Atout.name(), 4));
        cards.add(3, new Card(NameCardEnum.Green.name(), 5));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Sirene.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Sirene.name(), winnerCard.getName());
        Assertions.assertEquals(0, winnerCard.getValue());
        Assertions.assertEquals(cards.get(1), winnerCard);
    }

    @Test
    public void first_pirate_card_winner_against_all_cards_without_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Sirene.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 5));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Pirate.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Pirate.name(), winnerCard.getName());
        Assertions.assertEquals(0, winnerCard.getValue());
        Assertions.assertEquals(cards.get(2), winnerCard);
    }

    @Test
    public void skullKing_card_winner_against_all_cards_without_sirene_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 5));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.SkullKing.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.SkullKing.name(), winnerCard.getName());
        Assertions.assertEquals(0, winnerCard.getValue());
        Assertions.assertEquals(cards.get(5), winnerCard);
    }
    @Test
    public void sirene_card_winner_against_all_cards_with_pirate_and_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.SkullKing.name(), 0));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Sirene.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Sirene.name(), winnerCard.getName());
        Assertions.assertEquals(0, winnerCard.getValue());
        Assertions.assertEquals(cards.get(5), winnerCard);
    }
    @Test
    public void highest_value_card_winner_against_all_cards_because_of_baleine_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 10));
        cards.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(2, new Card(NameCardEnum.Baleine.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 10));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Sirene.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Yellow.name(), winnerCard.getName());
        Assertions.assertEquals(10, winnerCard.getValue());
        Assertions.assertEquals(cards.get(0), winnerCard);
    }

    @Test
    public void no_card_winner_because_of_kraken_without_baleine_after_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 10));
        cards.add(1, new Card(NameCardEnum.Kraken.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 10));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Sirene.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertNull(winnerCard);
    }

    @Test
    public void no_card_winner_because_of_all_echape_cards_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Echape.name(), 0));
        cards.add(1, new Card(NameCardEnum.Echape.name(), 0));
        cards.add(2, new Card(NameCardEnum.Echape.name(), 0));
        cards.add(3, new Card(NameCardEnum.Echape.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertNull(winnerCard);
    }

    @Test
    public void no_card_winner_because_of_all_echape_cards_and_baleine_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Echape.name(), 0));
        cards.add(1, new Card(NameCardEnum.Echape.name(), 0));
        cards.add(2, new Card(NameCardEnum.Baleine.name(), 0));
        cards.add(3, new Card(NameCardEnum.Echape.name(), 0));
        cards.add(4, new Card(NameCardEnum.Echape.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertNull(winnerCard);
    }

    @Test
    public void no_card_winner_because_of_kraken_after_baleine_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 10));
        cards.add(1, new Card(NameCardEnum.Baleine.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 10));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Kraken.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertNull(winnerCard);
    }

    @Test
    public void yellow10_card_winner_because_of_baleine_after_kraken_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 10));
        cards.add(1, new Card(NameCardEnum.Kraken.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 10));
        cards.add(4, new Card(NameCardEnum.SkullKing.name(), 0));
        cards.add(5, new Card(NameCardEnum.Baleine.name(), 0));

        // When
        Card winnerCard = foldManagement.selectWinner(cards);

        // Then
        Assertions.assertEquals(NameCardEnum.Yellow.name(), winnerCard.getName());
        Assertions.assertEquals(10, winnerCard.getValue());
        Assertions.assertEquals(cards.get(0), winnerCard);
    }
}
