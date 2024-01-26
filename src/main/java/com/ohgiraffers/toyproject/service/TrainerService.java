package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.TrainerBag;

import java.util.Scanner;

public class TrainerService {

    public void battleSellect() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. 싸운다");
        System.out.println("2. 가방");
        System.out.println("3. 도망간다");
        System.out.println("------------");
        System.out.print("나는! : ");
        int select = sc.nextInt();

        switch (select) {
            case 1: this.orderAttack();
                break;
            case 2: this.openBag();
                break;
            case 3:
                System.out.println("배틀을 종료합니다");
                System.out.println("무사히 도망쳤습니다!");
                return;
        }
    }

    // 싸우기
    public void orderAttack() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("포켓몬 기술 선택: ");
        int skill = sc1.nextInt();
        switch (skill) {
            case 1:
                /* 포켓몬 공격1 */
                break;
            case 2:
                /* 포켓몬 공격2 */
                break;
        }
        System.out.println("가 공격을 명령합니다.");    // 포켓몬 기술과 기술 메소드에서 받아서 사용
    }

    // 도망가기
    public void runAway() {
        System.out.println("배틀을 종료합니다.");
        return;
    }

    //가방 열기
    public void openBag() {
        Scanner sc2 = new Scanner(System.in);
        System.out.print("1. 회복약 사용 2. 몬스터볼 사용 3. 갯수 확인");
        int item = sc2.nextInt();
        switch (item) {
            case 1: this.useHealItem();
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
    public void useHealItem() {
        TrainerBag.useHealItem();
        System.out.println("포켓몬을 회복시킵니다");
        System.out.println("남은 회복약은" + TrainerBag.getHealItemConut() + "개 입니다.");
    }

    // 포켓몬볼 던지기
    public void throwingBall() {
        TrainerBag.useMonsterBall();
        System.out.println("몬스터볼을 사용합니다.");
        System.out.println("남은 몬스터볼은 " + TrainerBag.getMonsterBallCount() + "개 입니다.");
    }
}
