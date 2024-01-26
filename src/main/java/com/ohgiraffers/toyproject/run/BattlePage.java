package com.ohgiraffers.toyproject.run;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.aggregate.Pokemon;
import com.ohgiraffers.toyproject.aggregate.Trainer;
import com.ohgiraffers.toyproject.service.TrainerService;

import java.util.Scanner;

public class BattlePage {
    private static final TrainerService ts = new TrainerService();

    private Trainer trainer = null;
    private Pokemon enemyPokemon = null;

    public BattlePage() {}

    public BattlePage(Battle battle, Trainer trainer, Pokemon enemyPokemon) {
        battle.startBattle();
        this.trainer = trainer;
        this.enemyPokemon = enemyPokemon;
    }

    public void battlePhase() {
        // 제일 앞에있는 포켓몬을 꺼낸다
        battleSelect();
    }

    private void battleSelect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 싸운다");
        System.out.println("2. 가방");
        System.out.println("3. 도망간다");
        System.out.println("------------");
        System.out.print("나는! : ");
        int select = sc.nextInt();

        switch (select) {
            case 1: ts.orderAttack();
                break;
            case 2: ts.openBag();
                break;
            case 3:
                System.out.println("배틀을 종료합니다");
                System.out.println("무사히 도망쳤습니다!");
                return;
        }
    }
}
