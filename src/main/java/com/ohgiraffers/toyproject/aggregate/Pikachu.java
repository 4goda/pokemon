package com.ohgiraffers.toyproject.aggregate;

public class Pikachu extends Pokemon{

    public Pikachu() {
    }

    public Pikachu(String name, String sound, int hp, Attribute attribute) {
        super(name, sound, hp, attribute);
    }

    @Override
    public String specialAttack() {
        return null;
    }

}

