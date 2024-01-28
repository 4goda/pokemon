package com.ohgiraffers.toyproject.repository;

import com.ohgiraffers.toyproject.aggregate.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {


    private ArrayList<Pokemon> pokemonList = new ArrayList<>();
    private String filePath = "src/main/java/com/ohgiraffers/toyproject/db/pokemon.dat";



    public PokemonRepository() {
        List<Pokemon> pokemons = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            pokemons.add(new Charmander("파이리", "파이파이", 80, Attribute.FIRE));
            pokemons.add(new Squirtle("꼬부기", "꼬북", 70, Attribute.WATER));
            pokemons.add(new Pikachu("피카츄", "피카", 120, Attribute.ELETRONIC));
            pokemons.add(new Chikorita("치코리타", "치코", 60, Attribute.LEAF));

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

        }catch (EOFException e) {
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


    public Pokemon selectPokemon(int idx) {
        for (int i = 0; i < pokemonList.size(); i++) {
            if (idx == i) return pokemonList.get(i);
        }

        return null;
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

}
