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
        List<Integer> totalEachColorAndAtout = new ArrayList<>();

        // When
        for (int nameCardEnumIndex = 0; nameCardEnumIndex < NameCardEnum.Pirate.ordinal(); nameCardEnumIndex++) {
            int finalNameCardEnumIndex = nameCardEnumIndex;
            totalEachColorAndAtout.add((int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.getNameCard(finalNameCardEnumIndex).name())).count());
        }

        // Then
        for (Integer total : totalEachColorAndAtout) {
            Assertions.assertEquals(14, total);
        }
    }

    @Test
    public void total_of_each_special_card_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();
        List<Integer> totalEachSpecialCard = new ArrayList<>();

        // When
        for (int nameCardEnumIndex = NameCardEnum.Pirate.ordinal(); nameCardEnumIndex < NameCardEnum.values().length; nameCardEnumIndex++) {
            int finalNameCardEnumIndex = nameCardEnumIndex;
            totalEachSpecialCard.add((int) deck.stream().filter(c -> c.getName().equals(NameCardEnum.getNameCard(finalNameCardEnumIndex).name())).count());
        }

        // Then
        for (int totalEachSpecialCardIndex = 0; totalEachSpecialCardIndex < totalEachSpecialCard.size(); totalEachSpecialCardIndex++) {
            Assertions.assertEquals(NameCardEnum.getNameCard(totalEachSpecialCardIndex + NameCardEnum.Pirate.ordinal()).getMultiplicityOfCardEnum(), totalEachSpecialCard.get(totalEachSpecialCardIndex));
        }
    }

    @Test
    public void all_color_and_atout_cards_are_distinct_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();
        List<Boolean> allDistincts = new ArrayList<>();

        // When
        for (int nameCardEnumIndex = 0; nameCardEnumIndex < NameCardEnum.Pirate.ordinal(); nameCardEnumIndex++) {
            int finalNameCardEnumIndex = nameCardEnumIndex;
            allDistincts.add(deck.stream().filter(c -> c.getName().equals(NameCardEnum.getNameCard(finalNameCardEnumIndex).name())).distinct().count() != 1);
        }
        // Then
        for (Boolean distinct : allDistincts) {
            Assertions.assertTrue(distinct);
        }
    }

    @Test
    public void all_each_special_card_are_equals_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();
        List<Boolean> allEquals = new ArrayList<>();

        // When
        for (int nameCardEnumIndex = NameCardEnum.Pirate.ordinal(); nameCardEnumIndex < NameCardEnum.values().length; nameCardEnumIndex++) {
            int finalNameCardEnumIndex = nameCardEnumIndex;
            allEquals.add(deck.stream().filter(c -> c.getName().equals(NameCardEnum.getNameCard(finalNameCardEnumIndex).name())).distinct().count() == 1);
        }
        // Then
        for (Boolean equal : allEquals) {
            Assertions.assertTrue(equal);
        }
    }
}
