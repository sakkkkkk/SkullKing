package com.soprasteria.serviceImplTest;

import com.soprasteria.enums.NameCardEnum;
import com.soprasteria.service.impl.BonusScoreServiceImpl;
import com.soprasteria.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BonusScoreServiceImpl.class)
public class BonusScoreServiceImplTest {

    private final Integer POINTS_PER_COLOR_VALUE_14_COLLECTED = 10;
    private final Integer POINTS_PER_PIRATE_COLLECTED = 30;
    private final Integer POINTS_FOR_ATOUT_VALUE_14_COLLECTED = 30;
    private final Integer POINTS_PER_SIRENE_COLLECTED = 20;
    private final Integer POINTS_FOR_SKULLKING_COLLECTED = 40;
    private final Integer ZERO_EXPECTED = 0;
    
    private final BonusScoreServiceImpl bonusScoreManagement = new BonusScoreServiceImpl();

    @Test
    void bonus_20_with_two_cards_color_value_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Green.name(), 14));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(2 * POINTS_PER_COLOR_VALUE_14_COLLECTED);
    }

    @Test
    void bonus_60_with_skullKing_card_winner_and_two_pirates_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 5));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.SkullKing.name(), 0));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(2 * POINTS_PER_PIRATE_COLLECTED);
    }

    @Test
    void bonus_80_with_skullKing_card_winner_and_two_pirates_and_atout_card_number_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 5));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 14));
        cards.add(5, new Card(NameCardEnum.SkullKing.name(), 0));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(2 * POINTS_PER_PIRATE_COLLECTED + POINTS_FOR_ATOUT_VALUE_14_COLLECTED);
    }

    @Test
    void bonus_20_with_first_pirate_card_winner_against_sirene_and_collecting_one_pirate_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Sirene.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Atout.name(), 8));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Pirate.name(), 0));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(POINTS_PER_SIRENE_COLLECTED);
    }

    @Test
    void bonus_40_with_pirate_card_winner_against_sirene_and_collecting_one_pirate_and_atout_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Sirene.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Atout.name(), 14));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Pirate.name(), 0));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(POINTS_PER_SIRENE_COLLECTED + POINTS_FOR_ATOUT_VALUE_14_COLLECTED);
    }

    @Test
    void bonus_40_with_sirene_card_winner_against_and_collecting_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.SkullKing.name(), 0));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Sirene.name(), 0));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(POINTS_FOR_SKULLKING_COLLECTED);
    }

    @Test
    void bonus_70__with_sirene_card_winner_collecting_skullKing_and_yellow_14_and_atout_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 14));
        cards.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.SkullKing.name(), 0));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 14));
        cards.add(5, new Card(NameCardEnum.Sirene.name(), 0));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(POINTS_FOR_SKULLKING_COLLECTED + POINTS_PER_COLOR_VALUE_14_COLLECTED + POINTS_FOR_ATOUT_VALUE_14_COLLECTED);
    }

    @Test
    void bonus_0_with_sirene_card_winner_without_skullKing_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Atout.name(), 10));
        cards.add(2, new Card(NameCardEnum.Sirene.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 4));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Purple.name(), 9));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(ZERO_EXPECTED);
    }

    @Test
    void bonus_20_with_sirene_card_winner_without_skullKing_collecting_yellow_and_green_14_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 14));
        cards.add(1, new Card(NameCardEnum.Atout.name(), 10));
        cards.add(2, new Card(NameCardEnum.Sirene.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 14));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Purple.name(), 9));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(2 * POINTS_PER_COLOR_VALUE_14_COLLECTED);
    }

    @Test
    void fold_delayed_by_kraken_in_this_fold() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 10));
        cards.add(1, new Card(NameCardEnum.Kraken.name(), 0));
        cards.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards.add(3, new Card(NameCardEnum.Green.name(), 10));
        cards.add(4, new Card(NameCardEnum.Atout.name(), 3));
        cards.add(5, new Card(NameCardEnum.Sirene.name(), 0));

        // When
        int bonusScore = bonusScoreManagement.countBonus(cards);

        // Then
        assertThat(bonusScore).isEqualTo(ZERO_EXPECTED);
    }
}
