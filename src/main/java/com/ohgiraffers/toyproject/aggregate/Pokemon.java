package com.ohgiraffers.toyproject.aggregate;

import java.io.Serializable;
import java.util.Objects;

public abstract class Pokemon implements Serializable {

    public static final String DEFAULT_SKILL = "몸통 박치기";
    private String name;
    private String sound;
    private int hp = 0;
    private int maxHp = 0;
    private boolean isAlive;
    private Attribute attribute;

    public Pokemon() {
    }

    public Pokemon(String name, String sound, int hp, Attribute attribute) {
        this.name = name;
        this.sound = sound;
        this.hp = hp;
        this.maxHp = hp;
        this.attribute = attribute;
        this.isAlive = true;
    }

    public int getMaxHp() {
        return maxHp;
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

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    /* 설명. 전달된 skillNum값에 따라 현재 포켓몬이 보유한 기본 스킬 또는 special 스킬명을 반환한다. */
    public String attack(int skillNum){
        if(skillNum == 1)
            return defaultAttack();
        return specialAttack();
    }

    /* 설명. 포켓몬의 기본 스킬명을 반환한다. */
    public String defaultAttack(){
        return Pokemon.DEFAULT_SKILL;
    }

    /* 설명. 각 포켓몬마다 다르게 보유한 스킬명을 반환한다.(포켓몬마다 보유한 스킬이 다르므로 추상메소드로 선언) */
    public abstract String specialAttack();

    /* 설명. 공격받은 데미지를 전체 hp에서 감소한 후, 현재 포켓몬의 hp가 0 이하일 경우 isAlive 상태를 바꿔준다. */
    public void receiveDamage(int damage){
        hp -= damage;
        if(hp <= 0) isAlive = false;
    }

    /* 설명. 포켓몬에게 회복약을 사용했을 경우, 전달된 회복량만큼 포켓몬의 hp를 증가시킨다.(회복할 수 있는 최대값은 현재 포켓몬의 maxHp로 한다.) */
    public void healPokemon(int recovery){
        hp += recovery;
        if(hp >= maxHp) {
            hp = maxHp;
        }
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
