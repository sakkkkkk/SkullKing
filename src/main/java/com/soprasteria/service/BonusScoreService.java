package com.soprasteria.service;

import com.soprasteria.model.Card;
import com.soprasteria.service.impl.BonusScoreServiceImpl;

import java.util.List;

public interface BonusScoreService {
    int countBonus(List<Card> cards);
}
