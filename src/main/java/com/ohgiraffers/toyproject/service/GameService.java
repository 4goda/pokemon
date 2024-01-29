package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.aggregate.Pikachu;
import com.ohgiraffers.toyproject.aggregate.Pokemon;
import com.ohgiraffers.toyproject.aggregate.Trainer;
import com.ohgiraffers.toyproject.repository.GameRepository;
import com.ohgiraffers.toyproject.repository.PokemonRepository;

import java.util.List;
import java.util.Scanner;

public class GameService {

    /* TODO. 아직 게임 저장/불러오기 없으니 GameService에서 대부분 처리한다 */
    private final GameRepository gr = new GameRepository();
    private final PokemonRepository pr = new PokemonRepository();

    public GameService() {
    }
    
    public Pokemon selectStartingPokemon() {
        Scanner sc = new Scanner(System.in);

        // TODO pokemon은 추후에 객체로 바꿔야 함
        Pokemon pokemon = null;

        while (true) {
            System.out.println("==========================");
            System.out.println("너의 포켓몬을 골라보려무나!");
            System.out.println("==========================");
            System.out.println("-------------------");
            System.out.println("1. 피카츄");
            System.out.println("2. 파이리");
            System.out.println("3. 꼬부기");
            System.out.println("4. 이상해씨");
            System.out.println("-------------------");
            System.out.println("9. 게임 종료");
            System.out.print("내가 선택할 포켓몬은! : ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
//                    pokemon = new Pikachu();
                    pokemon = pr.selectPokemon("피카츄");
                    System.out.println("가랏! 피카츄!     피까피까");
                    return pokemon;
                case 2:
//                    pokemon = new "파이리";
                    pokemon = pr.selectPokemon("파이리");
                    System.out.println("가랏! 파이리!     파이파이");
                    return pokemon;
                case 3:
//                    pokemon = new "꼬부기";
                    pokemon = pr.selectPokemon("꼬부기");
                    System.out.println("가랏! 꼬부기!     꼬북꼬북");
                    return pokemon;
                case 4:
//                    pokemon = new "이상해씨";
                    pokemon = pr.selectPokemon("치코리타");
                    System.out.println("가랏! 치코리타!   치코치코");
                    return pokemon;
                case 9:
                    System.out.println("다음에 다시 오려무나~");
                    break;
                default:
                    System.out.println("다시 선택해주세요");
            }
        }
    }

    public Pokemon getEnemyPokemon(Pokemon startingPokemon) {
        Pokemon enemyPokemon = null;
        List<Pokemon> pokemonList = pr.getPokemonList();

        // enemyPokemon = 포켓몬 db에서 startingPokemon을 제외한 포켓몬 중 한 마리 선택
        do {
            int random = (int) (Math.random() * pokemonList.size());
            enemyPokemon = pokemonList.get(random);
        }while (startingPokemon.equals(enemyPokemon));

        return enemyPokemon;
    }
}
