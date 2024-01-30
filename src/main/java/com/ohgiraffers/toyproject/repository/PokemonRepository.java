package com.ohgiraffers.toyproject.repository;

import com.ohgiraffers.toyproject.aggregate.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonRepository {


    private ArrayList<Pokemon> pokemonList = new ArrayList<>();
    private String filePath = "src/main/java/com/ohgiraffers/toyproject/db/pokemon.dat";


    public PokemonRepository() {
        List<Pokemon> pokemons = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            pokemons.add(new Charmander("파이리", "파이파이", 140, Attribute.FIRE));
            pokemons.add(new Squirtle("꼬부기", "꼬북", 130, Attribute.WATER));
            pokemons.add(new Pikachu("피카츄", "피카", 145, Attribute.ELETRONIC));
            pokemons.add(new Chikorita("치코리타", "치코", 125, Attribute.LEAF));
            pokemons.add(new Mewtwo("뮤츠", "크와아아아아앙!", 5000, Attribute.GOD));

            savePokemon(pokemons);
        }

        loadPokemon();

    }


    private void savePokemon(List<Pokemon> pokemons) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(filePath)));

            for (Pokemon pokemon : pokemons) { // 넘어온 포켓몬 수만큼 출력
                oos.writeObject(pokemon);
            }

            oos.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void loadPokemon() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(filePath)));

            while (true) {
                pokemonList.add((Pokemon) ois.readObject());
            }


        } catch (EOFException e) {
            System.out.println("pokemonList = " + pokemonList);
            System.out.println("포켓몬 정보 로딩 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Pokemon selectPokemon(String pokemonName) {
        for (int i = 0; i < pokemonList.size(); i++) {
            // 포켓몬 DB에서 이름으로 객체 반환
            if(pokemonList.get(i).getName().equals(pokemonName)) return pokemonList.get(i);
        }

        return null;

    }
    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }


}
