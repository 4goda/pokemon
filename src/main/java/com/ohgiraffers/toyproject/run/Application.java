package com.ohgiraffers.toyproject.run;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.original.DTO.Game;
import com.ohgiraffers.toyproject.service.BattleService;
import com.ohgiraffers.toyproject.service.GameService;
import com.ohgiraffers.toyproject.service.SkillService;

import java.util.Scanner;

public class Application {

    private static final GameService gs = new GameService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==========================");
            System.out.println("포켓몬스터 게임을 시작합니다");
            System.out.println("==========================");
            System.out.println("1. 새로운 게임 시작");
            System.out.println("2. 게임 불러오기");
            System.out.println("3. 저장된 게임 삭제");
            System.out.println("9. 게임 종료");
            System.out.print("메뉴를 선택해 주세요 : ");

            int input = sc.nextInt();

            switch (input) {
                case 1:
//                    gs.startNewGame();
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
                    System.out.println("다시 선택해주세요");
            }
        }
    }

    private static void startNewGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("포켓몬 트레이너의 이름을 작성해주세요 : ");

        // TODO. 트레이너 객체 추가 되면 트레이너 팀이 수정해주세요
        sc.nextLine();

        // 설명. 트레이너 정보가 객체에 저장된 경우 [포켓몬 선택] 시작
        gs.selectStartingPokemon();

        Battle battle = Battle.getInstance();

        final BattleService bs = new BattleService();
        // 설명. 배틀 시작
        bs.startBattle(battle);
    }

}