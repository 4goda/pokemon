package pokemon.com.ohgiraffers.run;

import pokemon.com.ohgiraffers.DTO.Game;
import pokemon.com.ohgiraffers.interfaces.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        // Singleton으로 Game 객체 생성
        Game game = Game.getInstance();

        // Game 시작
        game.startGame();

        // Game 상태 확인
        System.out.println(game.gameStatus());

        // 스타팅 포켓몬 선택
        String myPokemon = game.startingPokemon();












        // Game 종료
        game.endGame();

    }
}