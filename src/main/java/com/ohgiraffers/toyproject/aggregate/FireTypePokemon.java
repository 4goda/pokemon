package com.ohgiraffers.toyproject.aggregate;

public abstract class FireTypePokemon extends Pokemon implements FireType{

    public FireTypePokemon() {
    }

    public FireTypePokemon(String name, String sound, int hp) {
        super(name, sound, hp);
    }

    @Override
    public String attack(int skillNum) {
       if(skillNum == 1) return defaultAttack();
       else return attckFireSkill();
    }
}
