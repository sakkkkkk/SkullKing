package com.soprasteria.serviceImplTest;

import com.soprasteria.enums.NameCardEnum;
import com.soprasteria.service.impl.DeckServiceImpl;
import com.soprasteria.model.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckServiceImplTest {

    private final Integer NUMBER_OF_CARDS_PER_COLOR_AND_ATOUT = 14;
    private final Integer NUMBER_OF_PIRATE = 6;
    private final Integer NUMBER_OF_SIRENE = 2;
    private final Integer NUMBER_OF_SKULLKING = 1;
    private final Integer NUMBER_OF_KRAKEN = 1;
    private final Integer NUMBER_OF_BALEINE = 1;
    private final Integer NUMBER_OF_ECHAPE = 7;

    DeckServiceImpl deckManagement = new DeckServiceImpl();

    @Test
    void test_total_cards_in_skullking_deck() {
        // Given & When
        List<Card> deck = deckManagement.skullKingDeck();

        // Then
        int totalExpected = 4 * NUMBER_OF_CARDS_PER_COLOR_AND_ATOUT + NUMBER_OF_PIRATE + NUMBER_OF_SIRENE
                + NUMBER_OF_SKULLKING + NUMBER_OF_KRAKEN + NUMBER_OF_BALEINE + NUMBER_OF_ECHAPE;
        assertThat(deck.size()).isEqualTo(totalExpected);
    }

    @Test
    void test_total_of_each_color_cards_and_atout_in_the_skull_king_deck() {
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
    void test_total_of_each_special_card_in_the_skull_king_deck() {
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
    void test_if_all_color_and_atout_cards_are_distinct_in_the_skull_king_deck() {
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
    void test_if_all_each_special_card_type_are_equals_in_the_skull_king_deck() {
        // Given
        List<Card> deck = deckManagement.skullKingDeck();
        List<Boolean> eachCardTypeAllEquals = new ArrayList<>();

        // When
        for (int nameCardEnumIndex = NameCardEnum.Pirate.ordinal(); nameCardEnumIndex < NameCardEnum.values().length; nameCardEnumIndex++) {
            int finalNameCardEnumIndex = nameCardEnumIndex;
            eachCardTypeAllEquals.add(deck.stream().filter(c -> c.getName().equals(NameCardEnum.getNameCard(finalNameCardEnumIndex).name())).distinct().count() == 1);
        }
        // Then
        for (Boolean equal : eachCardTypeAllEquals) {
            Assertions.assertTrue(equal);
        }
    }
}
