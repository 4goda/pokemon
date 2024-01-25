package com.ohgiraffers.toyproject.service;

import com.ohgiraffers.toyproject.aggregate.Battle;
import com.ohgiraffers.toyproject.repository.GameRepository;

import java.util.Scanner;

public class GameService {

    /* TODO. 아직 게임 저장/불러오기 없으니 GameService에서 대부분 처리한다 */
    private final GameRepository gr = new GameRepository();

    public GameService() {
    }


    public void startNewGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("포켓몬 트레이너의 이름을 작성해주세요 : ");

        // TODO. 트레이너 객체 추가 되면 트레이너 팀이 수정해주세요
        sc.nextLine();

        // 설명. 트레이너 정보가 객체에 저장된 경우 [포켓몬 선택] 시작
        selectStartingPokemon();

        Battle battle = Battle.getInstance();

        final BattleService bs = new BattleService();
        // 설명. 배틀 시작
        bs.startBattle(battle);
    }


    private void selectStartingPokemon() {
        Scanner sc = new Scanner(System.in);

        // TODO pokemon은 추후에 객체로 바꿔야 함
        String pokemon = "";

        while (true) {
            System.out.println("==========================");
            System.out.println("너의 포켓몬을 골라보려무나!");
            System.out.println("==========================");
            System.out.println("-------------------");
            System.out.println("1. 피카츄");
            System.out.println("2. 파이리");
            System.out.println("3. 꼬부기");
            System.out.println("4. 이상해씨");
            System.out.println("-------------------");
            System.out.println("9. 게임 종료");
            System.out.print("내가 선택할 포켓몬은! : ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    pokemon = "피카츄";
                    System.out.println("가랏! 피카츄!     피까피까");
                    break;
//                    return pokemon;
                case 2:
                    pokemon = "파이리";
                    System.out.println("가랏! 파이리!     파이파이");
                    break;
//                    return pokemon;
                case 3:
                    pokemon = "꼬부기";
                    System.out.println("가랏! 꼬부기!     꼬북꼬북");
                    break;
//                    return pokemon;
                case 4:
                    pokemon = "이상해씨";
                    System.out.println("가랏! 이상해씨!   이상이상");
                    break;
//                    return pokemon;
                case 9:
                    System.out.println("다음에 다시 오려무나~");
                    break;
                default:
                    System.out.println("다시 선택해주세요");
            }
        }
    }

}
