package com.soprasteria.managementTest;

import com.soprasteria.service.impl.ScoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Math.abs;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ScoreServiceImpl.class)
public class ScoreManagementTest {
    private final ScoreServiceImpl scoreManagement = new ScoreServiceImpl();

    @Test
    public void plus_10_per_fold_if_bet_0_fold_success() {
        // Given
        int bet = 0;
        int foldsWon = 0;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        assertThat(score).isEqualTo(setNumber * 10);
    }

    @Test
    public void minus_10_per_fold_if_bet_0_fold_failed() {
        // Given
        int bet = 0;
        int foldsWon = 1;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then

        assertThat(score).isEqualTo(- setNumber * 10);
    }

    @Test
    public void plus_20_per_fold_won_if_bet_sup_to_0_fold_success_in_the_5th_set() {
        // Given
        int bet = 2;
        int foldsWon = 2;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        assertThat(score).isEqualTo(bet * 20);
    }

    @Test
    public void minus_10_per_difference_between_bet_and_folds_won_if_bet_sup_to_0_failed_in_the_5th_set() {
        // Given
        int bet = 2;
        int foldsWon = 1;
        int setNumber = 5;

        // When
        int score = scoreManagement.scoreCounter(bet, foldsWon, setNumber);

        // Then
        assertThat(score).isEqualTo(- abs(bet - foldsWon) * 10);
    }
}
