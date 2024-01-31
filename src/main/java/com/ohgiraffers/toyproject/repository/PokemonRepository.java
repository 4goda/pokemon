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

        /* 설명. 포켓몬 파일이 존재하지 않으면 파일로 데이터를 생성한다. */
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


    /* 설명. 포켓몬 리스트를 받아와 Object단위로 파일에 저장한다. */
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

    /* 설명. 포켓몬 리스트에 존재하는 포켓몬들을 Object단위로 파일에서 로딩해 저장한다. */
    private void loadPokemon() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(filePath)));

            // 게임 종료하지 않은 상태에서 새로 불러올 경우 초기화
            if(!pokemonList.isEmpty()){
                pokemonList.clear();
            }

            while (true) {
                pokemonList.add((Pokemon) ois.readObject());
            }

        } catch (EOFException e) {
//            System.out.println("pokemonList = " + pokemonList);
//            System.out.println("포켓몬 정보 로딩 완료");
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


    /* 설명. 전달된 포켓몬의 이름을 리스트에서 찾아 해당하는 포켓몬 객체를 반환한다. */
    public Pokemon selectPokemon(String pokemonName) {
        for (int i = 0; i < pokemonList.size(); i++) {
            // 포켓몬 DB에서 이름으로 객체 반환
            if(pokemonList.get(i).getName().equals(pokemonName)) return pokemonList.get(i);
        }

        return null;
    }

    /* 설명. 체력 초기화를 위해 포켓몬 리스트를 초기화한다. */
    public ArrayList<Pokemon> getPokemonList() {
        pokemonList.clear();
        loadPokemon();
        return pokemonList;
    }


}
