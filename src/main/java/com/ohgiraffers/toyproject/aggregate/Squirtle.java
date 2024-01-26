package com.ohgiraffers.toyproject.aggregate;

public class Squirtle extends Pokemon {
    public Squirtle() {
    }

    public Squirtle(String name, String sound, int hp, Attribute attribute) {
        super(name, sound, hp, attribute);
    }

    @Override
    public String specialAttack() {
        return null;
    }

    // 기능 맵 어케 되는지?
}
