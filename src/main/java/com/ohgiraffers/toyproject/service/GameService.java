package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.repository.GameRepository;

public class GameService {

    /* TODO. 아직 게임 저장/불러오기 없으니 GameService에서 대부분 처리한다 */
    private final GameRepository gr = new GameRepository();

    public GameService() {
    }


    public void startNewGame() {
        gr.startNewGame();
    }
}
