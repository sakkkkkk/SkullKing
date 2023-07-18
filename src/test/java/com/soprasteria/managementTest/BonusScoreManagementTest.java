package com.soprasteria.managementTest;

import com.soprasteria.management.BonusScoreManagement;
import com.soprasteria.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = BonusScoreManagement.class)
public class BonusScoreManagementTest {

    private final BonusScoreManagement bonusScoreManagement = new BonusScoreManagement();

    @Test
    public void bonus_20_with_two_number_card_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 5, 1));
        cards.add(1, new Card("purple", 14, 2));
        cards.add(2, new Card("green", 14, 3));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(20, bonusScore);
    }

    @Test
    public void bonus_60_with_skullKing_card_winner_and_two_pirates_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 5, 1));
        cards.add(1, new Card("pirate", 0, 2));
        cards.add(2, new Card("pirate", 0, 3));
        cards.add(3, new Card("green", 5, 4));
        cards.add(4, new Card("atout", 3, 5));
        cards.add(5, new Card("skullKing", 0, 6));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(60, bonusScore);
    }

    @Test
    public void bonus_70_with_skullKing_card_winner_and_two_pirates_and_one_card_number_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 5, 1));
        cards.add(1, new Card("pirate", 0, 2));
        cards.add(2, new Card("pirate", 0, 3));
        cards.add(3, new Card("green", 5, 4));
        cards.add(4, new Card("atout", 14, 5));
        cards.add(5, new Card("skullKing", 0, 6));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(70, bonusScore);
    }

    @Test
    public void bonus_20_with_pirate_card_winner_against_sirene_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 5, 1));
        cards.add(1, new Card("sirene", 0, 2));
        cards.add(2, new Card("pirate", 0, 3));
        cards.add(3, new Card("atout", 8, 4));
        cards.add(4, new Card("atout", 3, 5));
        cards.add(5, new Card("pirate", 0, 6));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(20, bonusScore);
    }

    @Test
    public void bonus_30_with_pirate_card_winner_against_sirene_and_atout_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 5, 1));
        cards.add(1, new Card("sirene", 0, 2));
        cards.add(2, new Card("pirate", 0, 3));
        cards.add(3, new Card("atout", 14, 4));
        cards.add(4, new Card("atout", 3, 5));
        cards.add(5, new Card("pirate", 0, 6));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(30, bonusScore);
    }

    @Test
    public void bonus_40_sirene_card_winner_against_all_cards_with_pirate_and_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 5, 1));
        cards.add(1, new Card("pirate", 0, 2));
        cards.add(2, new Card("pirate", 0, 3));
        cards.add(3, new Card("skullKing", 0, 4));
        cards.add(4, new Card("atout", 3, 5));
        cards.add(5, new Card("sirene", 0, 6));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(40, bonusScore);
    }

    @Test
    public void bonus_40_sirene_card_winner_against_skullKing_and_yellow_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 14, 1));
        cards.add(1, new Card("pirate", 0, 2));
        cards.add(2, new Card("pirate", 0, 3));
        cards.add(3, new Card("skullKing", 0, 4));
        cards.add(4, new Card("atout", 3, 5));
        cards.add(5, new Card("sirene", 0, 6));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(50, bonusScore);
    }

    @Test
    public void bonus_0_sirene_card_winner_without_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 5, 1));
        cards.add(1, new Card("atout", 10, 2));
        cards.add(2, new Card("sirene", 0, 3));
        cards.add(3, new Card("green", 4, 4));
        cards.add(4, new Card("atout", 3, 5));
        cards.add(5, new Card("purple", 9, 6));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(0, bonusScore);
    }

    @Test
    public void fold_delayed_by_kraken_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card("yellow", 10, 1));
        cards.add(1, new Card("kraken", 0, 2));
        cards.add(2, new Card("pirate", 0, 3));
        cards.add(3, new Card("green", 10, 4));
        cards.add(4, new Card("atout", 3, 5));
        cards.add(5, new Card("sirene", 0, 6));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        Assertions.assertEquals(0, bonusScore);
    }
}
