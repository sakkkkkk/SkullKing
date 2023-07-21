package com.soprasteria.managementTest;

import com.soprasteria.NameCardEnum;
import com.soprasteria.management.DeckManagement;
import com.soprasteria.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeckManagementTest {

    DeckManagement deckManagement = new DeckManagement();
    @Test
    public void total_cards_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();

        // When

        // Then
        Assertions.assertEquals(74, deck.size());
    }

    @Test
    public void total_of_each_color_cards_and_atout_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();

        // When
        int totalOfYellow = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Yellow.name())).count();
        int totalOfGreen = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Green.name())).count();
        int totalOfPurple = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Purple.name())).count();
        int totalOfAtout = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Atout.name())).count();

        // Then
        Assertions.assertEquals(14, totalOfYellow);
        Assertions.assertEquals(14, totalOfGreen);
        Assertions.assertEquals(14, totalOfPurple);
        Assertions.assertEquals(14, totalOfAtout);
    }

    @Test
    public void total_of_each_special_cards_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();

        // When
        int totalOfPirate = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Pirate.name())).count();
        int totalOfSirene = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Sirene.name())).count();
        int totalOfSkullKing = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.SkullKing.name())).count();
        int totalOfBaleine = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Baleine.name())).count();
        int totalOfKraken = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Kraken.name())).count();
        int totalOfEchape = (int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.Echape.name())).count();

        // Then
        Assertions.assertEquals(6, totalOfPirate);
        Assertions.assertEquals(2, totalOfSirene);
        Assertions.assertEquals(1, totalOfSkullKing);
        Assertions.assertEquals(1, totalOfBaleine);
        Assertions.assertEquals(1, totalOfKraken);
        Assertions.assertEquals(7, totalOfEchape);
    }

    @Test
    public void all_color_and_atout_cards_distinct_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();

        // When
        List<Boolean> allDistinct = new ArrayList<>();
        for (int nameCardEnumIndex = 0; nameCardEnumIndex < NameCardEnum.values().length; nameCardEnumIndex++) {
            if (nameCardEnumIndex < NameCardEnum.Pirate.ordinal()) {
                int finalNameCardEnumIndex = nameCardEnumIndex;
                allDistinct.add(deck.stream().filter(c -> c.getName().equals(NameCardEnum.getNameCard(finalNameCardEnumIndex).name())).distinct().count() != 1);
            }
        }
        // Then
        for (Boolean distinct : allDistinct) {
            Assertions.assertTrue(distinct);
        }
    }
}
