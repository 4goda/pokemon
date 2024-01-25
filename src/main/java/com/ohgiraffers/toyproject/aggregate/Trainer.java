package com.ohgiraffers.toyproject.aggregate;

public class Trainer {
    // 추후 포켓몬은 포켓몬 객체로 바꾸기
    private String pokemon;
    private String playerName;


    // 배틀선택지 번호 고르기
    // 1. 싸운다 2. 도망가기 3. 가방(포켓몬볼, 회복약)
    public void orderAttack(String pokemon) {
        System.out.println(pokemon + "이 배틀을 시작합니다.");
    }

    public void runAway() {
        System.out.println("도망쳤습니다.");
        System.out.println("배틀종료");
    }

    public void openBag() {
        //포켓몬볼 사용(포켓몬 잡기), 회복약 사용
    }

    public void usingHealItem() {
        System.out.println("회복약을 사용합니다.");
    }

    public void throwingBall() {
        System.out.println("몬스터볼을 사용합니다. ");
    }
}
