package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.*;
import com.ohgiraffers.toyproject.exception.ChoiceException;
import com.ohgiraffers.toyproject.exception.NotEnoughHealItem;
import com.ohgiraffers.toyproject.exception.NotEnoughMonsterBall;
import com.ohgiraffers.toyproject.repository.PokemonRepository;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TrainerService {
    private Trainer trainer = null;
    private PokemonRepository pr = new PokemonRepository();

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    // 싸우기
    public String orderAttack(Pokemon pokemon) {
        // TODO. pokemon의 기술 목록 가져오기 (pokemon.getSkills())
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("1. " + pokemon.defaultAttack());
            System.out.println("2. " + pokemon.specialAttack());

            System.out.print("포켓몬 기술 선택: ");

            int skill = -1;
            try {
                skill = sc.nextInt();
            }catch (InputMismatchException e ){
                // 아래 ChoiceException과 메세지 겹침
                sc.nextLine();
            }

            switch (skill) {
                case 1:
                    /* 포켓몬 공격1 */
                    return pokemon.defaultAttack();
                case 2:
                    /* 포켓몬 공격2 */
                    return pokemon.specialAttack();
                default:
                    System.out.println("다른 스킬 번호를 입력하였습니다. 다시 입력해주세요");
                    break;
            }
        }
    }

    // 도망가기
    public void runAway() {
        System.out.println("배틀을 종료합니다.");
        return;
    }

    //가방 열기
    public void openBag(Pokemon pokemon, Pokemon enemyPokemon, Battle battle) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("1. 회복약 사용 2. 몬스터볼 사용 3. 갯수 확인 4. 가방 닫기");
            System.out.print("선택해주세요 : ");

            int item = -1;
            try {
                item = sc.nextInt();
            }catch (InputMismatchException e ){
                // 아래 ChoiceException과 메세지 겹침
                sc.nextLine();
            }

            switch (item) {
                case 1:
                    this.useHealItem(pokemon, battle);
                    return;
                case 2:
                    this.throwingBall(enemyPokemon, battle);
                    return;
                case 3:
                    System.out.println("현재 사용가능한 갯수는 회복약 \'" + trainer.getTrainerBag().getHealItemConut() + "\'개," +
                            " 몬스터볼 \'" + trainer.getTrainerBag().getMonsterBallCount() + "\'개 입니다.");
                    break;
                case 4:
                    System.out.println("가방을 닫습니다.");
                    return;
                default:
                    try {
                        throw new ChoiceException("잘못된 선택지입니다.");
                    } catch (ChoiceException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    // 회복약 사용하기
    public void useHealItem(Pokemon pokemon, Battle battle) {
        if(trainer.getTrainerBag().getHealItemConut() > 0) {
            System.out.println(pokemon.getName() + " 을(를) 회복시킵니다");
            pokemon.healPokemon(50);            // recovery 값 변경 가능
            System.out.println(pokemon.getName() + " 의 현재 체력은 " + pokemon.getHp() + "입니다");
            trainer.getTrainerBag().useHealItem();
            System.out.println("남은 회복약은" + trainer.getTrainerBag().getHealItemConut() + "개 입니다.");
            battle.turnEnd();
        } else {
            try {
                throw new NotEnoughHealItem("남은 회복약이 없습니다.");
            } catch (NotEnoughHealItem e) {
                e.printStackTrace();
            }
        }

    }

    // 포켓몬볼 던지기
    public void throwingBall(Pokemon enemyPokemon, Battle battle) {
        if(trainer.getTrainerBag().getMonsterBallCount() > 0) {
            System.out.println("몬스터볼을 사용합니다.");
            trainer.getTrainerBag().useMonsterBall();
            System.out.println("남은 몬스터볼은 " + trainer.getTrainerBag().getMonsterBallCount() + "개 입니다.");

            double random = (int)(Math.random() * 40) + 40 + 1 + (((double) enemyPokemon.getMaxHp() - (double) enemyPokemon.getHp()) / (double) enemyPokemon.getMaxHp()) * 100;

            if(random >= 100) {     // 몬스터가 잡혔을 경우
                trainer.addTrainerPokemon(enemyPokemon);
                System.out.println(enemyPokemon.getName() + " 이(가) 잡혔습니다.");
                System.out.println("아싸! 잡았다. 넌! 내꺼야!!!");
                battle.endBattle();
            } else {                // 안잡혔을 경우
                System.out.println(enemyPokemon.getName() + " 이(가) 몬스터볼에서 나왔습니다");
                battle.turnEnd();
            }

        } else {
            try {
                throw new NotEnoughMonsterBall("남은 몬스터볼이 없습니다.");
            } catch (NotEnoughMonsterBall e) {
                e.printStackTrace();
            }
        }
    }
}
