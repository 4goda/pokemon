package com.ohgiraffers.toyproject.aggregate;

public class Battle {
    private static Battle battle;
    private int battleCount = 1;

    private Battle() {}

    public static Battle getInstance() {
        if(battle == null) {
            battle = new Battle();
        }

        return battle;
    }
    public void startBattle() {
        battleCount = 1;
        System.out.println("배틀을 시작합니다. ");
    }

    public void endBattle(){
        battleCount = 1;
        System.out.println("배틀을 종료합니다.");
    }

    public int turnCheck() {
        return battleCount;
    }

    public void turnEnd() {
        battleCount++;
    }

}
