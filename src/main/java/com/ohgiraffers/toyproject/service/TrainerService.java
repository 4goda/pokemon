package com.ohgiraffers.toyproject.service;

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
        System.out.println("가 공격을 명령합니다.");
    }

    // 도망가기
    public void runAway() {
        System.out.println("배틀을 종료합니다.");
        /* 배틀 나가는거 불러오기 */
    }

    //가방 열기
    public void openBag() {

    }

    // 회복약 사용하기
    public void useHealItem() {
        System.out.println("회복약을 사용합니다.");
    }

    private void setHealingPack() {

    }

    // 포켓몬볼 던지기
    public void throwingBall() {
        System.out.println("몬스터볼을 사용합니다. ");
    }
}
