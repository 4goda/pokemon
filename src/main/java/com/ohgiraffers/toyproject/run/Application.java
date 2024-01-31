package com.ohgiraffers.toyproject.run;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.aggregate.Pokemon;
import com.ohgiraffers.toyproject.aggregate.Trainer;
import com.ohgiraffers.toyproject.exception.ChoiceException;
import com.ohgiraffers.toyproject.exception.IllegalNameException;
import com.ohgiraffers.toyproject.service.BattleService;
import com.ohgiraffers.toyproject.service.GameService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    private static final GameService gs = new GameService();

    /* 설명. 포켓몬스터 게임 메뉴 출력 기능*/
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===========================================");
            System.out.println("포켓몬스터 게임을 시작합니다");
            System.out.println("===========================================");
            System.out.println("1. 새로운 게임 시작");
            System.out.println("2. 게임 불러오기");
            System.out.println("3. 저장된 게임 삭제");
            System.out.println("9. 게임 종료");
            System.out.print("메뉴를 선택해 주세요 : ");

            int input = -1;
            try {
                input = sc.nextInt();
            }catch (InputMismatchException e ){
                // 아래 ChoiceException과 메세지 겹침
                sc.nextLine();
            }

            switch (input) {
                case 1:
                    startNewGame();
                    break;
                case 2:
//                    gs.loadGame();
                    break;
                case 3:
//                    gs.deleteGame();
                    break;
                case 9:
                    System.out.println("게임을 종료합니다");
                    return;
                default:
                    try {
                        throw new ChoiceException("잘못된 선택지입니다.");
                    } catch (ChoiceException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    /* 설명. 트레이너 이름과 트레이너 포켓몬을 정하는 기능*/
    private static void startNewGame() {
        Trainer trainer = null;

        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("포켓몬 트레이너의 이름을 작성해주세요 : ");

            String name = sc.nextLine();
            trainer = new Trainer(1, name);

            if(!Pattern.matches("^[a-zA-Zㄱ-ㅎ가-힣]*$", name)){
                throw new IllegalNameException("잘못된 이름을 입력하였습니다. 공백없이 한글 또는 영어를 입력해주세요");
            }

            System.out.println("트레이너의 이름은 : " + name + "입니다");
            System.out.println();

            // 설명. 트레이너 정보가 객체에 저장된 경우 [포켓몬 선택] 시작
            Pokemon startingPokemon = gs.selectStartingPokemon();
            trainer.addTrainerPokemon(startingPokemon);

            Pokemon enemyPokemon = gs.getEnemyPokemon(startingPokemon);
            /* 설명. 배틀 시작하는 기능 실행*/
            Battle battle = Battle.getInstance();

            BattlePage battlePage = new BattlePage(battle, trainer, enemyPokemon);
            battlePage.battlePhase();
        } catch (IllegalNameException e) {
            e.printStackTrace();
        }
    }

}