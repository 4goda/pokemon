package pokemon.main;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StartingPokemon startingPokemon = new StartingPokemon();

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
            System.out.println("9. 프로그램 종료");
            System.out.print("내가 선택할 포켓몬은! : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    System.out.println("가랏! 피카츄!     피까피까");
                    break;
                case 2:
                    System.out.println("가랏! 파이리!     파이파이");
                    break;
                case 3:
                    System.out.println("가랏! 꼬부기!     꼬북꼬북");
                    break;
                case 4:
                    System.out.println("가랏! 이상해씨!   이상이상");
                    break;
                case 9:
                    System.out.println("다음에 다시 오려무나~");
                    return;
            }
        }
    }
}