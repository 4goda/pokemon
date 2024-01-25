package com.ohgiraffers.toyproject.aggregate;

public class TrainerBag {

    // 트레이너는 몬스터볼과 회복약을 5개씩 보유(사용하면 Count--)
    private int monsterBallCount = 5;

    private int healingPackConut = 5;

    public TrainerBag() {
    }

    public TrainerBag(int monsterBallCount, int healingPackConut) {
        this.monsterBallCount = monsterBallCount;
        this.healingPackConut = healingPackConut;
    }

    public int getMonsterBallCount() {
        return monsterBallCount;
    }

    public int getHealingPackConut() {
        return healingPackConut;
    }

    public void useHealingPack() {
        healingPackConut--;
    }
    public void setMonsterBallCount(int monsterBallCount) {
        this.monsterBallCount = monsterBallCount;
    }

    public void setHealingPackConut(int healingPackConut) {
        this.healingPackConut = healingPackConut;
    }
}
