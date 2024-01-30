package com.ohgiraffers.toyproject.aggregate;

import java.io.*;
import java.util.Scanner;

public class SaveTrainer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 트레이너 이름 입력");
            System.out.println("2. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    saveTrainer();
                    break;
                case 2:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    private static void saveTrainer() {
        Scanner scanner = new Scanner(System.in);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/ohgiraffers/toyproject/db/TrainerSave", true))) {
            int trainerNumber = getNextUserNumber();

            System.out.print("이름을 입력하세요: ");
            String name = scanner.nextLine();

            // 사용자 정보를 파일에 저장
            writer.write(trainerNumber + "," + name);
            writer.newLine();

            System.out.println("저장되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getNextUserNumber() {
        int maxUserNumber = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/ohgiraffers/toyproject/db/TrainerSave"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int userNumber = Integer.parseInt(parts[0]);
                if (userNumber > maxUserNumber) {
                    maxUserNumber = userNumber;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return maxUserNumber + 1;
    }
}
