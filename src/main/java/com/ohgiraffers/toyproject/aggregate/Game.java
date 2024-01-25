package com.ohgiraffers.toyproject.aggregate;

public class Game {
    private boolean isOn;                   // 실행상태

    public Game() {
    }

    public void startGame() {
        isOn = true;
    }

    public void endGame() {
        isOn = false;
    }


}
