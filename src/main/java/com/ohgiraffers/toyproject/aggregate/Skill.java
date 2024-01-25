package com.ohgiraffers.toyproject.aggregate;

public class Skill {
    private String name;        // 스킬 이름
    private int damage;         // 스킬 데미지
    private String type;        // 스킬 타입

    public Skill() {
    }

    public Skill(String name, int damage, String type) {
        this.name = name;
        this.damage = damage;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", type='" + type + '\'' +
                '}';
    }
}
