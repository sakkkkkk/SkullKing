package com.soprasteria.serviceImplTest;

import com.soprasteria.model.Card;
import com.soprasteria.model.Player;
import com.soprasteria.service.impl.DeckServiceImpl;
import com.soprasteria.service.impl.DistributionServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DistributionServiceImplTest {

    private final int MAX_NUMBER_OF_PLAYERS = 8;

    private final DistributionServiceImpl distributionService = new DistributionServiceImpl();
    private final DeckServiceImpl deckService = new DeckServiceImpl();

    @Test
    void test_distribution_of_cards_for_two_players_in_the_1st_set() {
        // Given
        int setNumber = 1;
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Romain", 0, new ArrayList<>()));
        players.add(new Player(2, "Arthur", 0, new ArrayList<>()));

        List<Card> skullKingDeck = deckService.skullKingDeck();
        Collections.shuffle(skullKingDeck);

        // When
        List<List<Card>> playersCards = distributionService.distributeCards(skullKingDeck, players, setNumber);

        // Then
        assertThat(playersCards.size()).isEqualTo(players.size());
        assertThat(playersCards.get(0).size()).isEqualTo(setNumber);
        assertThat(playersCards.get(0).get(0)).isEqualTo(players.get(0).getCards().get(0));
        assertThat(players.get(0).getCards().get(0)).isNotEqualTo(players.get(1).getCards().get(0));
    }

    @Test
    void test_distribution_of_cards_for_two_players_in_the_2nd_set() {
        // Given
        int setNumber = 2;
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Romain", 0, new ArrayList<>()));
        players.add(new Player(2, "Arthur", 0, new ArrayList<>()));

        List<Card> skullKingDeck = deckService.skullKingDeck();
        Collections.shuffle(skullKingDeck);

        // When
        List<List<Card>> playersCards = distributionService.distributeCards(skullKingDeck, players, setNumber);

        // Then
        assertThat(playersCards.size()).isEqualTo(players.size());
        assertThat(playersCards.get(0).size()).isEqualTo(setNumber);
        assertThat(playersCards.get(0).get(0)).isEqualTo(players.get(0).getCards().get(0));
        assertThat(players.get(0).getCards().get(0)).isNotEqualTo(players.get(1).getCards().get(0));
    }

    @Test
    void test_distribution_of_cards_for_two_players_in_the_3rd_set() {
        // Given
        int setNumber = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Romain", 0, new ArrayList<>()));
        players.add(new Player(2, "Arthur", 0, new ArrayList<>()));

        List<Card> skullKingDeck = deckService.skullKingDeck();
        Collections.shuffle(skullKingDeck);

        // When
        List<List<Card>> playersCards = distributionService.distributeCards(skullKingDeck, players, setNumber);

        // Then
        assertThat(playersCards.size()).isEqualTo(players.size());
        assertThat(playersCards.get(0).size()).isEqualTo(setNumber);
        assertThat(playersCards.get(0).get(0)).isEqualTo(players.get(0).getCards().get(0));
        assertThat(players.get(0).getCards().get(0)).isNotEqualTo(players.get(1).getCards().get(0));
    }

    @Test
    void test_distribution_of_cards_for_8_players_in_the_3rd_set() {
        // Given
        int setNumber = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Jean", 0, new ArrayList<>()));
        players.add(new Player(2, "Nicolas", 0, new ArrayList<>()));
        players.add(new Player(3, "Alexandre", 0, new ArrayList<>()));
        players.add(new Player(4, "Nadir", 0, new ArrayList<>()));
        players.add(new Player(5, "Jeanne", 0, new ArrayList<>()));
        players.add(new Player(6, "Gaetan", 0, new ArrayList<>()));
        players.add(new Player(7, "Lea", 0, new ArrayList<>()));
        players.add(new Player(8, "Theo", 0, new ArrayList<>()));

        List<Card> skullKingDeck = deckService.skullKingDeck();
        Collections.shuffle(skullKingDeck);

        // When
        List<List<Card>> playersCards = distributionService.distributeCards(skullKingDeck, players, setNumber);

        // Then
        assertThat(playersCards.size()).isEqualTo(players.size());
        assertThat(playersCards.get(0).size()).isEqualTo(setNumber);
        assertThat(playersCards.get(0).get(0)).isEqualTo(players.get(0).getCards().get(0));
        assertThat(players.get(0).getCards().get(0)).isNotEqualTo(players.get(1).getCards().get(0));
    }

    @Test
    void test_distribution_of_cards_for_8_players_in_the_9th_set() {
        // Given
        int setNumber = 9;
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Jean", 0, new ArrayList<>()));
        players.add(new Player(2, "Nicolas", 0, new ArrayList<>()));
        players.add(new Player(3, "Alexandre", 0, new ArrayList<>()));
        players.add(new Player(4, "Nadir", 0, new ArrayList<>()));
        players.add(new Player(5, "Jeanne", 0, new ArrayList<>()));
        players.add(new Player(6, "Gaetan", 0, new ArrayList<>()));
        players.add(new Player(7, "Lea", 0, new ArrayList<>()));
        players.add(new Player(8, "Theo", 0, new ArrayList<>()));

        List<Card> skullKingDeck = deckService.skullKingDeck();
        Collections.shuffle(skullKingDeck);

        // When
        List<List<Card>> playersCards = distributionService.distributeCards(skullKingDeck, players, setNumber);

        // Then
        assertThat(playersCards.size()).isEqualTo(players.size());
        assertThat(playersCards.get(0).size()).isEqualTo(setNumber);
        assertThat(playersCards.get(0).get(0)).isEqualTo(players.get(0).getCards().get(0));
        assertThat(players.get(0).getCards().get(0)).isNotEqualTo(players.get(1).getCards().get(0));
    }

    @Test
    void test_distribution_of_cards_for_8_players_in_the_10th_set() {
        // Given
        int setNumber = 10;
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Jean", 0, new ArrayList<>()));
        players.add(new Player(2, "Nicolas", 0, new ArrayList<>()));
        players.add(new Player(3, "Alexandre", 0, new ArrayList<>()));
        players.add(new Player(4, "Nadir", 0, new ArrayList<>()));
        players.add(new Player(5, "Jeanne", 0, new ArrayList<>()));
        players.add(new Player(6, "Gaetan", 0, new ArrayList<>()));
        players.add(new Player(7, "Lea", 0, new ArrayList<>()));
        players.add(new Player(8, "Theo", 0, new ArrayList<>()));

        List<Card> skullKingDeck = deckService.skullKingDeck();
        Collections.shuffle(skullKingDeck);

        // When
        List<List<Card>> playersCards = distributionService.distributeCards(skullKingDeck, players, setNumber);

        if (players.size() == MAX_NUMBER_OF_PLAYERS) {
            setNumber = 9;
        }

        // Then
        assertThat(playersCards.size()).isEqualTo(players.size());
        assertThat(playersCards.get(0).size()).isEqualTo(setNumber);
        assertThat(playersCards.get(0).get(0)).isEqualTo(players.get(0).getCards().get(0));
        assertThat(players.get(0).getCards().get(0)).isNotEqualTo(players.get(1).getCards().get(0));
    }
}
