package com.soprasteria.serviceImplTest;

import com.soprasteria.service.impl.ScoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ScoreServiceImpl.class)
public class ScoreServiceImplTest {

    private final Integer POINTS_PER_FOLD_IF_BET_EQUALS_0 = 10;
    private final Integer POINTS_PER_FOLD_IF_BET_SUP_TO_0_FAILED = 10;
    private final Integer POINTS_PER_FOLD_IF_BET_SUP_TO_0_SUCCESS = 20;

    private final ScoreServiceImpl scoreManagement = new ScoreServiceImpl();

    @Test
    void test_plus_10_per_fold_if_bet_0_fold_success() {
        // Given
        int bet = 0;
        int foldsWon = 0;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        assertThat(score).isEqualTo(setNumber * POINTS_PER_FOLD_IF_BET_EQUALS_0);
    }

    @Test
    void test_minus_10_per_fold_if_bet_0_fold_failed() {
        // Given
        int bet = 0;
        int foldsWon = 1;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        assertThat(score).isEqualTo(- setNumber * POINTS_PER_FOLD_IF_BET_EQUALS_0);
    }

    @Test
    void test_plus_20_per_fold_won_if_bet_sup_to_0_fold_success_in_the_5th_set() {
        // Given
        int bet = 2;
        int foldsWon = 2;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        assertThat(score).isEqualTo(bet * POINTS_PER_FOLD_IF_BET_SUP_TO_0_SUCCESS);
    }

    @Test
    void test_minus_10_per_difference_between_bet_and_folds_won_if_bet_sup_to_0_failed_in_the_5th_set() {
        // Given
        int bet = 2;
        int foldsWon = 1;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        assertThat(score).isEqualTo(- abs(bet - foldsWon) * POINTS_PER_FOLD_IF_BET_SUP_TO_0_FAILED);
    }
}
