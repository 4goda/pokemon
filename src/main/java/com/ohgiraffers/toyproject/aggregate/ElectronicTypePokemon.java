package com.ohgiraffers.toyproject.aggregate;

public abstract class ElectronicTypePokemon extends Pokemon implements ElectronicType {

    public ElectronicTypePokemon() {
    }

    public ElectronicTypePokemon(String name, String sound, int hp) {
        super(name, sound, hp);
    }

    @Override
    public String attack(int skillNum) {
        if(skillNum == 1)
            return defaultAttack();
        else
            return attckElectronicSkill();
    }

}

