package com.ohgiraffers.toyproject.aggregate;

import java.util.ArrayList;

public abstract class Pokemon {

    public static final String DEFAULT_SKILL = "몸통 박치기";
    private String name;
    private String sound;
    private int hp;
    private boolean isAlive;

    public Pokemon() {
    }

    public Pokemon(String name, String sound, int hp) {
        this.name = name;
        this.sound = sound;
        this.hp = hp;
        this.isAlive = true;
    }

    public abstract String attack(int skillNum);

    public String defaultAttack(){
        return Pokemon.DEFAULT_SKILL;
    }

    public void receiveDamage(int damage){
        hp -= damage;
        if(hp <= 0) isAlive = false;
    }

    public void run(){
        isAlive = false;
    }

}
