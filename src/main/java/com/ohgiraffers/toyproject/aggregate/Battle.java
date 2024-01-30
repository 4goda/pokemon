package com.ohgiraffers.toyproject.aggregate;

public class Battle {
    private static Battle battle;
    private int battleCount = 1;
    private boolean battleOn;

    private Battle() {}

    public static Battle getInstance() {
        if(battle == null) {
            battle = new Battle();
        }

        return battle;
    }
    public void startBattle() {
        battleOn = true;
        System.out.println("배틀을 시작합니다. ");
    }

    public void endBattle() {
        battleOn = false;
        battleCount = 1;
        System.out.println("배틀을 종료합니다.");
    }

    public int turnCheck() {
        return battleCount;
    }

    public void turnEnd() {
        battleCount++;
        System.out.println("턴 종료되었습니다");
    }

    public boolean isBattleOn() {
        return battleOn;
    }

}
