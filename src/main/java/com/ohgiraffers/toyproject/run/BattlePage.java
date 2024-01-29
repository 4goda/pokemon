package com.ohgiraffers.toyproject.run;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.aggregate.Pokemon;
import com.ohgiraffers.toyproject.aggregate.Trainer;
import com.ohgiraffers.toyproject.repository.PokemonRepository;
import com.ohgiraffers.toyproject.service.BattleService;
import com.ohgiraffers.toyproject.service.SkillService;
import com.ohgiraffers.toyproject.service.TrainerService;

import java.util.Scanner;

public class BattlePage {
    private static final TrainerService ts = new TrainerService();
    private static final SkillService ss = new SkillService();
    private static final BattleService bs = new BattleService();
    private PokemonRepository pr = new PokemonRepository();

    private Trainer trainer = null;
    private Pokemon enemyPokemon = null;

    public BattlePage() {}

    public BattlePage(Battle battle, Trainer trainer, Pokemon enemyPokemon) {
        battle.startBattle();
        this.trainer = trainer;
        this.enemyPokemon = enemyPokemon;
    }

    public void battlePhase() {
        // 설명. 제일 앞에있는 포켓몬을 꺼낸다
        Pokemon selectedPokemon = pr.selectPokemon(trainer.getTrainerPokemon(0));

        //while(bs.endBattle() 호출 될 때까지){
        battleSelect(selectedPokemon);
        // 적 포켓몬의 공격
        bs.endBattle(trainer.getTrainerName(), selectedPokemon, enemyPokemon);
        // while문 종료 }
    }

    private void battleSelect(Pokemon selectedPokemon) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. 싸운다");
        System.out.println("2. 가방");
        System.out.println("3. 도망간다");
        System.out.println("------------");
        System.out.print("나는! : ");
        int select = sc.nextInt();

        switch (select) {
            case 1:
                String castingSkill = ts.orderAttack(selectedPokemon);  // 사용한 스킬명 (100만볼트)
                int calcDamage = ss.selectSkill(castingSkill);          // 스킬의 계산된 공격 데미지
                bs.fightBattle(calcDamage, enemyPokemon);
                break;
            case 2: ts.openBag(selectedPokemon);
                break;
            case 3:
                System.out.println("배틀을 종료합니다");
                System.out.println("무사히 도망쳤습니다!");
                return;
        }
    }
}
