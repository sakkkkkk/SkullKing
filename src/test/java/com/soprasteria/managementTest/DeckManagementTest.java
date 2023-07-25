package com.soprasteria.managementTest;

import com.soprasteria.enums.NameCardEnum;
import com.soprasteria.service.impl.DeckServiceImpl;
import com.soprasteria.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckManagementTest {

    DeckServiceImpl deckManagement = new DeckServiceImpl();
    @Test
    public void total_cards_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();

        // When

        // Then
        int totalExpected = 4 * 14 + 6 + 2 + 1 + 1 + 1 + 7;
        assertThat(deck.size()).isEqualTo(totalExpected);
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
        for (int totalIndex = 0; totalIndex < totalEachColorAndAtout.size(); totalIndex++) {
            assertThat(totalEachColorAndAtout.get(totalIndex)).isEqualTo(NameCardEnum.getNameCard(totalIndex).getMultiplicityOfCardEnum());
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
            assertThat(totalEachSpecialCard.get(totalEachSpecialCardIndex)).isEqualTo(NameCardEnum.getNameCard(totalEachSpecialCardIndex + NameCardEnum.Pirate.ordinal()).getMultiplicityOfCardEnum());
        }
    }

    @Test
    public void all_color_and_atout_cards_are_distinct_in_deck_of_skull_king_game() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();
        List<Boolean> allDistinct = new ArrayList<>();

        // When
        for (int nameCardEnumIndex = 0; nameCardEnumIndex < NameCardEnum.Pirate.ordinal(); nameCardEnumIndex++) {
            int finalNameCardEnumIndex = nameCardEnumIndex;
            allDistinct.add(deck.stream().filter(c -> c.getName().equals(NameCardEnum.getNameCard(finalNameCardEnumIndex).name())).distinct().count() != 1);
        }
        // Then
        for (Boolean distinct : allDistinct) {
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
