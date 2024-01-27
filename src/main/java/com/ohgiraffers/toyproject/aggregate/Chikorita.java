package com.ohgiraffers.toyproject.aggregate;

public class Chikorita extends Pokemon {

    public Chikorita() {
    }

    public Chikorita(String name, String sound, int hp, Attribute attribute) {
        super(name, sound, hp, attribute);
    }

    @Override
    public String specialAttack() {
        return null;
    }
}
