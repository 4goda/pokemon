package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.*;
import com.ohgiraffers.toyproject.repository.PokemonRepository;

import java.util.Scanner;


public class TrainerService {
    Trainer trainer = null;
    private PokemonRepository pr = new PokemonRepository();
    private Pokemon selectedPokemon;

    // 싸우기
    public String orderAttack(Pokemon pokemon) {
        // TODO. pokemon의 기술 목록 가져오기 (pokemon.getSkills())

        Scanner sc1 = new Scanner(System.in);

        System.out.print("포켓몬 기술 선택: ");
        int skill = sc1.nextInt();
        String skillName = "";

        switch (skill) {
            case 1:
                /* 포켓몬 공격1 */
                skillName = selectedPokemon.defaultAttack();
//                return "몸통박치기"
                break;
            case 2:
                /* 포켓몬 공격2 */
                skillName = selectedPokemon.specialAttack();
//                return "100만볼트"
                break;
        }
        System.out.println(trainer.getTrainerName() + "가 " +  skillName + " 공격을 명령합니다.");    // 포켓몬 기술과 기술 메소드에서 받아서 사용
        return null;
    }
    
    /*public void selectBattle() {
        selectedPokemon = pr.selectPokemon();   // 배틀 포켓몬 선택이 선행되어야 함 pokemonList의 idx 선택

        Scanner sc = new Scanner(System.in);
        System.out.println("1. 싸운다");
        System.out.println("2. 가방");
        System.out.println("3. 도망간다");
        System.out.println("------------");
        System.out.print("나는! : ");
        int select = sc.nextInt();

        switch (select) {
            case 1: this.orderAttack(selectedPokemon);
                break;
            case 2: this.openBag(selectedPokemon);
                break;
            case 3:
                System.out.println("배틀을 종료합니다");
                System.out.println("무사히 도망쳤습니다!");
                return;
        }
    }*/

    // 싸우기
//     public void orderAttack(Pokemon pokemon) {
//         Scanner sc1 = new Scanner(System.in);
//         System.out.print("포켓몬 기술 선택: ");
//         int skill = sc1.nextInt();
//         String skillName = pokemon.attack(skill);
//         System.out.println(skillName + "공격을 명령합니다.");    // 포켓몬 기술과 기술 메소드에서 받아서 사용
//     } // 게임에서 선택한 pokemon 객체에서 attack 함수 실행

    // 도망가기
    public void runAway() {
        System.out.println("배틀을 종료합니다.");
        return;
    }

    //가방 열기
    public void openBag(Pokemon pokemon) {
        Scanner sc2 = new Scanner(System.in);

        System.out.print("1. 회복약 사용 2. 몬스터볼 사용 3. 갯수 확인");
        int item = sc2.nextInt();

        switch (item) {
            case 1: this.useHealItem(pokemon);
                break;
            case 2: this.throwingBall();
                break;
            case 3:
                System.out.println("현재 사용가능한 갯수는 회복약 \'" + TrainerBag.getHealItemConut() + "\'개," +
                        " 몬스터볼 \'" + TrainerBag.getMonsterBallCount() + "\'개 입니다." );
                break;
        }
    }

    // 회복약 사용하기
    public void useHealItem(Pokemon pokemon) {
        System.out.println("포켓몬을 회복시킵니다");
        TrainerBag.useHealItem();
        pokemon.healPokemon(50);            // recovery 값 변경 가능

        System.out.println("남은 회복약은" + TrainerBag.getHealItemConut() + "개 입니다.");
    }

    // 포켓몬볼 던지기
    public void throwingBall() {
        System.out.println("몬스터볼을 사용합니다.");
        TrainerBag.useMonsterBall();
        // 상대 포켓몬 정보가 있어야 함 trainerPokemons에 넣기 위해

        System.out.println("남은 몬스터볼은 " + TrainerBag.getMonsterBallCount() + "개 입니다.");
    }
}
