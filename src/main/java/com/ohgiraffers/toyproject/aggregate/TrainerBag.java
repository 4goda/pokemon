package com.ohgiraffers.toyproject.aggregate;

public class TrainerBag {

    /* 설명. 트레이너는 기본적으로 몬스터볼과 회복약을 5개씩 보유한다. */
    private int monsterBallCount = 5;
    private int healItemConut = 5;

    public TrainerBag() {}

    /* 설명. 몬스터볼을 사용한다. */
    public void useMonsterBall() {
        monsterBallCount--;
    }

    /* 설명. 회복약을 사용한다. */
    public void useHealItem() {
        healItemConut--;
    }

    /* 설명. 몬스터볼 갯수를 리턴한다. */
    public int getMonsterBallCount() {
        return monsterBallCount;
    }

    /* 설명. 회복약 갯수 리턴한다. */
    public int getHealItemConut() {
        return healItemConut;
    }

}