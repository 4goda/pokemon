package com.ohgiraffers.toyproject.aggregate;

public class Mewtwo extends Pokemon {

    public Mewtwo() {
    }

    public Mewtwo(String name, String sound, int hp, Attribute attribute) {
        super(name, sound, hp, attribute);
    }

    @Override
    public String specialAttack() {
        return "파괴광선";
    }
}
