package com.soprasteria.enums;

public enum NameCardEnum {
    Yellow(14), Green(14), Purple(14), Atout(14), Pirate(6), Sirene(2), SkullKing(1), Baleine(1), Kraken(1), Echape(7);

    private final static NameCardEnum[] list = NameCardEnum.values();

    public static NameCardEnum getNameCard(int index) {
        return list[index];
    }

    private final int multiplicityOfCardEnum;

    NameCardEnum(int multiplicityOfCard) {
        this.multiplicityOfCardEnum = multiplicityOfCard;
    }

    public int getMultiplicityOfCardEnum() {
        return multiplicityOfCardEnum;
    }
}