package com.ohgiraffers.toyproject.aggregate;

public class TrainerBag {

    // 트레이너는 몬스터볼과 회복약을 5개씩 보유(사용하면 Count--)
    private int monsterBallCount =5;

    private int healItemConut = 5;

    public void useMonsterBall() {
        monsterBallCount--;
    }

    public void useHealItem() {
        healItemConut--;
    }


    public TrainerBag() {
    }

    public int getMonsterBallCount() {
        return monsterBallCount;
    }

    public int getHealItemConut() {
        return healItemConut;
    }

}