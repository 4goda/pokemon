package com.ohgiraffers.toyproject.run;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.aggregate.Pokemon;
import com.ohgiraffers.toyproject.aggregate.Trainer;
import com.ohgiraffers.toyproject.exception.ChoiceException;
import com.ohgiraffers.toyproject.repository.PokemonRepository;
import com.ohgiraffers.toyproject.service.BattleService;
import com.ohgiraffers.toyproject.service.SkillService;
import com.ohgiraffers.toyproject.service.TrainerService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BattlePage {
    private static final TrainerService ts = new TrainerService();
    private static final SkillService ss = new SkillService();
    private static final BattleService bs = new BattleService();
    private PokemonRepository pr = new PokemonRepository();

    private Battle battle = null;
    private Trainer trainer = null;
    private Pokemon enemyPokemon = null;

    public BattlePage() {}

    public BattlePage(Battle battle, Trainer trainer, Pokemon enemyPokemon) {
        battle.startBattle();
        this.battle = battle;
        this.trainer = trainer;
        ts.setTrainer(this.trainer);
        this.enemyPokemon = enemyPokemon;
    }

    public void battlePhase() {

        /* 설명. 트레이너가 보유한 포켓몬 중 제일 앞에있는 포켓몬을 꺼낸다 */
        Pokemon selectedPokemon = pr.selectPokemon(trainer.getTrainerPokemon(0));
        System.out.println();
        System.out.println("앗! 야생의 " + enemyPokemon.getName() + " 이(가) 나타났다!");
        System.out.println();

        while(battle.isBattleOn()) {

            if(battle.turnCheck() % 2 == 1) {       // 홀수턴은 트레이너의 차례
                selectTrainerOrder(selectedPokemon);
                if(!battle.isBattleOn()) break;    // 도망쳤을 경우
            } else {
                enemyAttack(selectedPokemon);
            }

            /* 설명. 전투 중인 포켓몬 둘 중 하나가 쓰러졌을 경우 전투 종료 */
            if(!selectedPokemon.isAlive() || !this.enemyPokemon.isAlive()){
                bs.endBattle(trainer.getTrainerName(), selectedPokemon, this.enemyPokemon);
                battle.endBattle();
            }
        }


    }

    private void selectTrainerOrder(Pokemon selectedPokemon) {
        System.out.println("===========================================");
        System.out.println(selectedPokemon.getName() + " 의 체력은 " + selectedPokemon.getHp() + "입니다");
        System.out.println(enemyPokemon.getName() + " 의 체력은 " + enemyPokemon.getHp() + "입니다");
        System.out.println("===========================================");
        Scanner sc = new Scanner(System.in);

        System.out.println("1. 싸운다");
        System.out.println("2. 가방");
        System.out.println("3. 도망간다");
        System.out.println("-------------------------------------------");
        System.out.print("선택해주세요 : ");

        int select = -1;
        try {
            select = sc.nextInt();
        }catch (InputMismatchException e ){
            // 아래 ChoiceException과 메세지 겹침
            sc.nextLine();
        }

        switch (select) {
            case 1:
                String castingSkill = ts.orderAttack(selectedPokemon);  // 사용한 스킬명 (100만볼트)
                int calcDamage = ss.selectSkill(castingSkill);          // 스킬의 계산된 공격 데미지
                System.out.println("-------------------------------------------");
                System.out.println(trainer.getTrainerName() + "의 \"" + selectedPokemon.getName() + "\"가 사용한 기술은 \"" + castingSkill + "!!\"");
                System.out.println(calcDamage + "의 데미지를 입혔다!");
                bs.calcHp(calcDamage, enemyPokemon);
//                System.out.println("적 포켓몬 : " + enemyPokemon.getName() + "\nhp : " + enemyPokemon.getHp());
                System.out.println();
                battle.turnEnd();
                break;
            case 2:
                ts.openBag(selectedPokemon, enemyPokemon, battle);
                break;
            case 3:
                battle.endBattle();
                System.out.println("무사히 도망쳤습니다!");
                break;
            default:
                try {
                    throw new ChoiceException("잘못된 선택지입니다.");
                } catch (ChoiceException e) {
                    e.printStackTrace();
                }
        }
    }

    private void enemyAttack(Pokemon trainerPokemon) {
        // 포켓몬의 공격
        // TODO. 포켓몬 스킬은 랜덤 발동으로 할 것
        int random = (int) (Math.random() * 2 + 1);
        String castingSkill = enemyPokemon.attack(random);
        int calcDamage = ss.selectSkill(castingSkill);
        bs.calcHp(calcDamage, trainerPokemon);
        System.out.println("야생의 \"" + enemyPokemon.getName() + "\"가 사용한 기술은 \"" + castingSkill + "!!\"");
        System.out.println(calcDamage + "의 데미지를 입었다!");
//        System.out.println("트레이너의 포켓몬 : " + trainerPokemon.getName() + "\nhp : " + trainerPokemon.getHp());
        System.out.println();
        battle.turnEnd();
    }
}
