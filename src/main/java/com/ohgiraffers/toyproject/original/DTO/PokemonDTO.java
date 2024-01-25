package com.ohgiraffers.toyproject.original.DTO;
import com.ohgiraffers.toyproject.original.interfaces.Pokemon;

public abstract class PokemonDTO implements Pokemon {

    // 속성은 인터페이스로 추가
    private String name;
    private int hp;
    private int power;          // Map으로 난수 생성하는 함수 통해서 가져오는 값
    private boolean isAlive;
    private String[] attribute;   // 나중에 인터페이스로 빼는(?)


    public PokemonDTO(String name, int hp, int power, boolean isAlive, String[] attribute) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.isAlive = isAlive;
        this.attribute = attribute;
    }

    public void attack(Pokemon pokemon){
        //int power = 나중에 인터페이스에서 범위 가져와서 계산하기
        pokemon.receiveDamage(power);
    }

    public void receiveDamage(int damage){
        hp -= damage;
        if(hp <= 0) isAlive = false;
    }

    public void run(){
        isAlive = false;
    }

}
