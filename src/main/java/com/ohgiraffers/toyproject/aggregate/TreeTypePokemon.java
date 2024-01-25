package com.ohgiraffers.toyproject.aggregate;

public abstract class TreeTypePokemon extends Pokemon implements TreeType{
    public TreeTypePokemon() {
    }

    public TreeTypePokemon(String name, String sound, int hp) {
        super(name, sound, hp);
    }

    @Override
    public String attack(int skillNum) {
        if(skillNum == 1) return defaultAttack();
        else return attckTreeSkill();
    }
}
