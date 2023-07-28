package com.soprasteria.service;

import com.soprasteria.model.Card;
import com.soprasteria.model.Player;

import java.util.List;

public interface DistributionService {
    List<List<Card>> distributeCards(List<Card> skullKingDeck, List<Player> players, int setNumber);
}
