package com.ohgiraffers.toyproject.aggregate;

public enum Attribute {
    WATER("물"),
    FIRE("불"),
    ELETRONIC("전기"),
    LEAF("풀"),

    GOD("신");

    private final String description;

    Attribute(String description) {
        this.description = description;
    }
}
