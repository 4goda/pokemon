package com.ohgiraffers.toyproject.aggregate;

public class TrainerBag {

    // 트레이너는 몬스터볼과 회복약을 5개씩 보유(사용하면 Count--)
    private static int monsterBallCount =5;

    private static int healItemConut = 5;

    public static void useMonsterBall() {
        monsterBallCount--;
    }

    public static void useHealItem() {
        healItemConut--;
    }


    public TrainerBag() {
    }

    public static int getMonsterBallCount() {
        return monsterBallCount;
    }

    public static int getHealItemConut() {
        return healItemConut;
    }

}