package com.ohgiraffers.toyproject.aggregate;

import java.io.Serializable;
import java.util.Objects;

public abstract class Pokemon implements Serializable {

    public static final String DEFAULT_SKILL = "몸통 박치기";
    private String name;
    private String sound;
    private int hp = 0;
    private boolean isAlive;
    private Attribute attribute;

    public Pokemon() {
    }

    public Pokemon(String name, String sound, int hp, Attribute attribute) {
        this.name = name;
        this.sound = sound;
        this.hp = hp;
        this.attribute = attribute;
        this.isAlive = true;
    }


    public String getName() {
        return name;
    }

//    public abstract String attack(int skillNum);

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getSound() {
        return sound;
    }

    public boolean getIsAlive() {
        return isAlive;
    }
    
    public String attack(int skillNum){
        if(skillNum == 1)
            return defaultAttack();
        return specialAttack();
    }

    public String defaultAttack(){
        return Pokemon.DEFAULT_SKILL;
    }

    public abstract String specialAttack();

    public void receiveDamage(int damage){
        hp -= damage;
        if(hp <= 0) isAlive = false;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void healPokemon(int recovery){
        hp += recovery;

    }

    public void run(){
        isAlive = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return hp == pokemon.hp && isAlive == pokemon.isAlive && Objects.equals(name, pokemon.name) && Objects.equals(sound, pokemon.sound) && attribute == pokemon.attribute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sound, hp, isAlive, attribute);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", sound='" + sound + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                ", attribute=" + attribute +
                '}';
    }
}
