package com.ohgiraffers.toyproject.original.interfaces.pokemon_interfaces;

import java.util.HashMap;

public interface WaterType {

    public static final HashMap<String, Integer> skills = new HashMap<>();

    public static void main(String[] args) {
        skills.put("물 쏘기1", 30);
        skills.put("물 쏘기2", 50);
        skills.put("물 쏘기3", 10);
        skills.put("물 쏘기4", 20);
        skills.put("물 쏘기5", 30);

        System.out.println(skills);
    }

}
