package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.TrainerBag;

import java.util.Scanner;

public class TrainerService {
    // 싸우기
    public void orderAttack() {
        Scanner sc = new Scanner(System.in);
        System.out.print("포켓몬 기술 선택: ");
        int input = sc.nextInt();
        switch (input) {
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
        Scanner sc = new Scanner(System.in);
        System.out.print("1. 회복약 사용 2. 몬스터볼 사용 3. 갯수 확인");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                /* ("현재 사용가능한 갯수는 회복약 \'" + + "\'개, 몬스터볼 \'" + + "\'개 입니다." ) */
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
