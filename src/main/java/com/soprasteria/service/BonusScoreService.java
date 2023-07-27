package com.soprasteria.service;

import com.soprasteria.model.Card;

import java.util.List;

public interface BonusScoreService {
    int countBonus(List<Card> cards);
}
