package com.soprasteria.service;

import com.soprasteria.model.Card;

import java.util.List;

public interface FoldService {
    Card selectWinner(List<Card> cards);
}
