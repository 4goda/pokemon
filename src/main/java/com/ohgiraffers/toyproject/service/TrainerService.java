package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.*;
import com.ohgiraffers.toyproject.exception.ChoiceException;
import com.ohgiraffers.toyproject.exception.NotEnoughHealItem;
import com.ohgiraffers.toyproject.exception.NotEnoughMonsterBall;
import com.ohgiraffers.toyproject.repository.PokemonRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class TrainerService {
    private Trainer trainer = null;
    private PokemonRepository pr = new PokemonRepository();

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    /* 설명. 트레이너가 포켓몬에게 공격 명령을 하기 위한 메소드 */
    public String orderAttack(Pokemon pokemon) {

        Scanner sc = new Scanner(System.in);

        /* 설명. 반복문으로 포켓몬 공격 1번과 2번 중 선택 */
        while (true) {
            System.out.println("1. " + pokemon.defaultAttack());
            System.out.println("2. " + pokemon.specialAttack());

            System.out.print("포켓몬 기술 선택: ");

            int skill = -1;
            /* 설명. try-catch문으로 숫자(1 or 2)가 아닐 시 예외 처리 */
            try {
                skill = sc.nextInt();
            }catch (InputMismatchException e ){
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
                    /* 설명. 1번 혹은 2번을 입력하지 않았을 시 예외처리 */
                    try {
                        throw new ChoiceException("잘못된 선택지입니다.");
                    } catch (ChoiceException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    /* 설명. 플레이어가 도망가기 위한 메소드(게임 종료) */
    public void runAway() {
        System.out.println("배틀을 종료합니다.");
        return;
    }

    /* 설명. 가방을 열면서 플레이어 포켓몬(회복약 사용), 적 포켓몬(몬스터볼 사용), 배틀 호출 */
    public void openBag(Pokemon pokemon, Pokemon enemyPokemon, Battle battle) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("1. 회복약 사용 2. 몬스터볼 사용 3. 갯수 확인 4. 가방 닫기");
            System.out.print("선택해주세요 : ");

            int item = -1;
            try {
                item = sc.nextInt();
            }catch (InputMismatchException e ){
                sc.nextLine();
            }

            switch (item) {
                case 1:
                    /* 설명. 회복약 사용 메소드 호출 */
                    this.useHealItem(pokemon, battle);
                    return;
                case 2:
                    /* 설명. 몬스터볼 사용 메소드 호출 */
                    this.throwingBall(enemyPokemon, battle);
                    return;
                case 3:
                    /* 설명. trainer -> getTrainerBag() -> getHealItemCount() or getMonsterBallCount() 순 */
                    System.out.println("-------------------------------------------");
                    System.out.println("현재 사용 가능한 갯수는 회복약 \'" + trainer.getTrainerBag().getHealItemConut() + "\'개," +
                            " 몬스터볼 \'" + trainer.getTrainerBag().getMonsterBallCount() + "\'개 입니다.");
                    System.out.println("-------------------------------------------");
                    break;
                case 4:
                    /* 설명. 가방을 닫고 반복문 빠져나가기 */
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
            System.out.println("-------------------------------------------");
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
            System.out.println("-------------------------------------------");
            System.out.println("몬스터볼을 사용합니다.");
            trainer.getTrainerBag().useMonsterBall();
            System.out.println("남은 몬스터볼은 " + trainer.getTrainerBag().getMonsterBallCount() + "개 입니다.");

            /* 설명. 몬스터볼 확률은 랜덤이고 기본값(랜덤) 40~80에 적 포켓몬이 체력이 낮을 수록 확률이 올라감 */
            double random = (int)(Math.random() * 40) + 40 + 1 + (((double) enemyPokemon.getMaxHp() - (double) enemyPokemon.getHp()) / (double) enemyPokemon.getMaxHp()) * 100;

            if(random >= 100) {     // 몬스터가 잡혔을 경우(랜덤 함수 +@ 가 100이상일 때)
                /* 설명. 현재 보유중인 포켓몬 리스트 함수로 출력 */
                List<String> myPokemon = new ArrayList<>();

                trainer.addTrainerPokemon(enemyPokemon);
                for (Pokemon p: trainer.getTrainerPokemons()) myPokemon.add(p.getName());

                System.out.println(enemyPokemon.getName() + " 이(가) 잡혔습니다.");
                System.out.println("아싸! 잡았다. 넌! 내꺼야!!!");
                System.out.println(trainer.getTrainerName() + "의 보유 포켓몬 목록: " + myPokemon);

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
