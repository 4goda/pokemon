package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.aggregate.Pikachu;
import com.ohgiraffers.toyproject.aggregate.Pokemon;
import com.ohgiraffers.toyproject.aggregate.Trainer;
import com.ohgiraffers.toyproject.repository.GameRepository;
import com.ohgiraffers.toyproject.repository.PokemonRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameService {
    private final GameRepository gr = new GameRepository();
    private final PokemonRepository pr = new PokemonRepository();

    public GameService() {
    }

    /* 설명. 트레이너가 첫 포켓몬을 선택한다. */
    public Pokemon selectStartingPokemon() {
        Scanner sc = new Scanner(System.in);

        Pokemon pokemon = null;

        while (true) {
            System.out.println("===========================================");
            System.out.println("너의 포켓몬을 골라보려무나!");
            System.out.println("===========================================");
            System.out.println("-------------------------------------------");
            System.out.println("1. 피카츄");
            System.out.println("2. 파이리");
            System.out.println("3. 꼬부기");
            System.out.println("4. 치코리타");
            System.out.println("-------------------------------------------");
            System.out.println("9. 게임 종료");
            System.out.print("내가 선택할 포켓몬은! : ");

            int input = -1;
            try {
                input = sc.nextInt();
            }catch (InputMismatchException e ){
                sc.nextLine();
            }

            System.out.println("-------------------------------------------");

            switch (input) {
                case 1:
                    pokemon = pr.selectPokemon("피카츄");
                    System.out.println("가랏! 피카츄!     피까피까");
                    return pokemon;
                case 2:
                    pokemon = pr.selectPokemon("파이리");
                    System.out.println("가랏! 파이리!     파이파이");
                    return pokemon;
                case 3:
                    pokemon = pr.selectPokemon("꼬부기");
                    System.out.println("가랏! 꼬부기!     꼬북꼬북");
                    return pokemon;
                case 4:
                    pokemon = pr.selectPokemon("치코리타");
                    System.out.println("가랏! 치코리타!   치코치코");
                    return pokemon;
                case 5:
                    pokemon = pr.selectPokemon("뮤츠");
                    System.out.println("뮤츠! 도와줘!    크와아아아아아앙ㅇㅇ");
                    return pokemon;
                case 9:
                    System.out.println("다음에 다시 오려무나~");
                    break;
                default:
                    System.out.println("다시 선택해주세요");
            }
        }
    }

    /* 설명. 트레이너가 고른 포켓몬과 다른 적 포켓몬을 랜덤으로 가져온다. */
    public Pokemon getEnemyPokemon(Pokemon startingPokemon) {
        Pokemon enemyPokemon = null;
        List<Pokemon> pokemonList = pr.getPokemonList();

        int mewtwoRandom = (int)(Math.random() * 100);

        do {
            if(mewtwoRandom < 10) {                                             // 10% 확률로 뮤츠를 적으로 만난다
                enemyPokemon = pr.getPokemonList().stream()
                        .filter(pokemon -> "뮤츠".equals(pokemon.getName()))
                        .findFirst()
                        .orElse(null);
            } else {
                int random = (int) (Math.random() * (pokemonList.size() - 1));  // 리스트 마지막에 있는 뮤츠는 제외
                enemyPokemon = pokemonList.get(random);
            }
        }while (startingPokemon.equals(enemyPokemon));

        return enemyPokemon;
    }
}
