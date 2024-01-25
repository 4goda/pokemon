package com.ohgiraffers.toyproject.run;

import com.ohgiraffers.toyproject.original.DTO.Game;
import com.ohgiraffers.toyproject.service.GameService;

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
                    gs.startNewGame();
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

}