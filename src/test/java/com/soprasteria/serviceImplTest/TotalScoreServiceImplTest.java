package com.soprasteria.serviceImplTest;

import com.soprasteria.enums.NameCardEnum;
import com.soprasteria.service.impl.TotalScoreServiceImpl;
import com.soprasteria.model.Card;
import com.soprasteria.model.Fold;
import com.soprasteria.model.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;

public class TotalScoreServiceImplTest {

    private final Integer POINTS_PER_FOLD_IF_BET_EQUALS_0_SUCCESS = 10;
    private final Integer POINTS_PER_FOLD_IF_BET_SUP_OR_EQUALS_TO_0_FAILED = -10;
    private final Integer POINTS_PER_FOLD_IF_BET_SUP_TO_0_SUCCESS = 20;
    private final Integer POINTS_PER_COLOR_VALUE_14_COLLECTED = 10;
    private final Integer POINTS_PER_PIRATE_COLLECTED = 30;
    private final Integer POINTS_FOR_ATOUT_VALUE_14_COLLECTED = 20;

    private final TotalScoreServiceImpl totalScoreManagement = new TotalScoreServiceImpl();

    @Test
    void test_total_score_30_if_bet_0_fold_success() {
        // Given
        List<Fold> folds = new ArrayList<>();
        Player player = new Player(1, "Anoussak", 0, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        assertThat(totalScore).isEqualTo(setNumber * POINTS_PER_FOLD_IF_BET_EQUALS_0_SUCCESS);
    }

    @Test
    void test_total_score_minus_30_if_bet_0_fold_failed() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Green.name(), 14));

        List<Fold> folds = new ArrayList<>();
        folds.add(0, new Fold(cards));

        Player player = new Player(1, "Anoussak", 0, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        assertThat(totalScore).isEqualTo(setNumber * POINTS_PER_FOLD_IF_BET_SUP_OR_EQUALS_TO_0_FAILED);
    }
    
    @Test
    void test_total_score_40_if_bet_1_fold_success_with_bonus_20_with_two_number_card_14_in_this_set() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Green.name(), 14));

        List<Fold> folds = new ArrayList<>();
        folds.add(0, new Fold(cards));

        Player player = new Player(1, "Anoussak", 1, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        assertThat(totalScore).isEqualTo(player.getBet() * POINTS_PER_FOLD_IF_BET_SUP_TO_0_SUCCESS + 2 * POINTS_PER_COLOR_VALUE_14_COLLECTED);
    }

    @Test
    void test_total_score_minus_10_if_bet_2_folds_failed() {
        // Given
        List<Card> cards = new ArrayList<>();
        cards.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards.add(2, new Card(NameCardEnum.Green.name(), 14));

        List<Fold> folds = new ArrayList<>();
        folds.add(0, new Fold(cards));

        Player player = new Player(1, "Anoussak", 2, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        assertThat(totalScore).isEqualTo(abs(player.getBet() - setNumber) * POINTS_PER_FOLD_IF_BET_SUP_OR_EQUALS_TO_0_FAILED);
    }

    @Test
    void test_total_score_140_with_bonus_80_first_fold_won_AND_bonus_20_second_fold_won_in_this_set() {
        // Given
        List<Card> cards1 = new ArrayList<>();
        cards1.add(0, new Card(NameCardEnum.Atout.name(), 14));
        cards1.add(1, new Card(NameCardEnum.Pirate.name(), 0));
        cards1.add(2, new Card(NameCardEnum.Pirate.name(), 0));
        cards1.add(3, new Card(NameCardEnum.SkullKing.name(), 0));

        List<Card> cards2 = new ArrayList<>();
        cards2.add(0, new Card(NameCardEnum.Yellow.name(), 5));
        cards2.add(1, new Card(NameCardEnum.Purple.name(), 14));
        cards2.add(2, new Card(NameCardEnum.Green.name(), 14));
        cards2.add(3, new Card(NameCardEnum.Green.name(), 5));

        List<Fold> folds = new ArrayList<>();
        folds.add(0, new Fold(cards1));
        folds.add(1, new Fold(cards2));

        Player player = new Player(1, "Anoussak", 2, folds);
        int setNumber = 3;

        // When
        int totalScore = totalScoreManagement.totalScore(player, setNumber);

        // Then
        int BONUS = POINTS_FOR_ATOUT_VALUE_14_COLLECTED + 2 * POINTS_PER_PIRATE_COLLECTED + 2 * POINTS_PER_COLOR_VALUE_14_COLLECTED;
        assertThat(totalScore).isEqualTo(player.getBet() * POINTS_PER_FOLD_IF_BET_SUP_TO_0_SUCCESS + BONUS);
    }
}