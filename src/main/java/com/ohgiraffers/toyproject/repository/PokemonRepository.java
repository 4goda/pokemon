package com.ohgiraffers.toyproject.repository;

import com.ohgiraffers.toyproject.aggregate.*;

import java.util.ArrayList;

public class PokemonRepository {

    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    public PokemonRepository() {
        pokemonList.add(new Charmander("파이리", "파이파이", 80, Attribute.FIRE));
        pokemonList.add(new Squirtle("꼬부기", "꼬북", 70, Attribute.WATER));
        pokemonList.add(new Pikachu("피카츄", "피카", 120, Attribute.ELETRONIC));
        pokemonList.add(new Chikorita("치코리타", "치코", 60, Attribute.LEAF));
    }

    public Pokemon selectPokemon(int idx) {
        for (int i = 0; i < pokemonList.size(); i++) {
            if (idx == i) return pokemonList.get(i);
        }

        return null;
    }

}
