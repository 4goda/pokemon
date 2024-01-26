package com.ohgiraffers.toyproject.aggregate;

public abstract class WaterTypePokemon extends Pokemon implements WaterType{
    public WaterTypePokemon() {
    }

    public WaterTypePokemon(String name, String sound, int hp) {
        super(name, sound, hp);
    }

    @Override
    public String attack(int skillNum) {
        if(skillNum == 1)
            return defaultAttack();
        else
            return attckWaterSkill();
    }
}
