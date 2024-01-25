package pokemon.com.ohgiraffers.DTO;

import pokemon.com.ohgiraffers.interfaces.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static Game game = new Game();  // EagerSingleton 으로 객체 생성
    private boolean isOn;                   // 실행상태
//    List<Pokemon> pokemonList = new ArrayList<>();
    // TODO 포켓몬 클래스 생성되면 옮기기
    //        pokemonList.add(new 피카츄)

    /* 설명. 추후에 추가할 기능
     *  1. 게임 저장 기능
     *  2. 게임 불러오기 기능
     *  3. 게임 settings(음량, 디스플레이, 화면 밝기, 키 설정) 기능
    * */

    private Game() {}

    // 인스턴스 생성
    public static Game getInstance() { return game; }

    // 게임 현재 실행 상태를 나타내는 객체
    public String gameStatus() {
        return "현재 상태는 : \" + (isOn ? \"[ON]\" : \"[OFF]\") + \"상태 입니다";
    }

    // 게임 실행
    public void startGame() {
        isOn = true;
    }

    // 게임 종료
    public void endGame() {
        isOn = false;
        System.exit(0);
    }

    // 게임 시작 후 고르는 포켓몬.
    public String startingPokemon() {
        Scanner sc = new Scanner(System.in);
        String pokemon = "";
        boolean isSelect;
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
            int no = sc.nextInt();

            switch (no) {
                    // TODO pokemon은 추후에 객체로 바꿔야 함
                case 1:
                    pokemon = "피카츄";
                    System.out.println("가랏! 피카츄!     피까피까");
                    return pokemon;
                case 2:
                    pokemon = "파이리";
                    System.out.println("가랏! 파이리!     파이파이");
                    return pokemon;
                case 3:
                    pokemon = "꼬부기";
                    System.out.println("가랏! 꼬부기!     꼬북꼬북");
                    return pokemon;
                case 4:
                    pokemon = "이상해씨";
                    System.out.println("가랏! 이상해씨!   이상이상");
                    return pokemon;
                case 9:
                    System.out.println("다음에 다시 오려무나~");
                    endGame();
                    break;
                default:
                    System.out.println("다시 선택해주세요");
            }
        }
    }

    // 몬스터볼 포획 확률 설정(?).



}
