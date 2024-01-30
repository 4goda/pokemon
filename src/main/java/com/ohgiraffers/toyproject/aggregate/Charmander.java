package com.ohgiraffers.toyproject.aggregate;

public class Charmander extends Pokemon {

    public Charmander () {
    }

    public Charmander (String name, String sound, int hp, Attribute attribute) {
        super(name, sound, hp, attribute);
    }

    @Override
    public String specialAttack() {
        return "불꽃세례";
    }
}
