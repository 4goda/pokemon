package com.ohgiraffers.toyproject.aggregate;

public abstract class LeafTypePokemon extends Pokemon implements LeafType {
    public LeafTypePokemon() {
    }

    public LeafTypePokemon(String name, String sound, int hp) {
        super(name, sound, hp);
    }

    @Override
    public String attack(int skillNum) {
        if(skillNum == 1) return defaultAttack();
        else return attckLeafSkill();
    }
}
