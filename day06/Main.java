package day06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidNameException, InvalidGenderException {
        Scanner sc = new Scanner(System.in);
        MaleCelebrity[] maleCelebs = {
                new MaleCelebrity("박서준"),
                new MaleCelebrity("차은우"),
                new MaleCelebrity("정해인"),
                new MaleCelebrity("이도현"),
                new MaleCelebrity("송강"),
                new MaleCelebrity("김선호"),
                new MaleCelebrity("안효섭"),
                new MaleCelebrity("도경수"),
                new MaleCelebrity("임시완"),
                new MaleCelebrity("이준호"),
                new MaleCelebrity("주우재")
        };

        FemaleCelebrity[] femaleCelebs = {
                new FemaleCelebrity("아이유"),
                new FemaleCelebrity("장원영"),
                new FemaleCelebrity("카리나"),
                new FemaleCelebrity("윈터"),
                new FemaleCelebrity("한소희"),
                new FemaleCelebrity("김세정"),
                new FemaleCelebrity("윤아"),
                new FemaleCelebrity("설현"),
                new FemaleCelebrity("제니"),
                new FemaleCelebrity("지수")
        };
        try {
            System.out.print("=== 이상형 월드컵 ===\n" +
                    "1. 남자 연예인 월드컵\n" +
                    "2. 여자 연예인 월드컵\n" +
                    "경기를 선택하세요: ");
            int game = Integer.parseInt(sc.nextLine());
            if (!(game == 1 || game == 2)) {
                throw new InvalidGenderException(">> 잘못된 선택입니다! 1 또는 2만 입력하세요.");
            }
            if (game == 1) {
                MaleMatchGame maleGame = new MaleMatchGame(maleCelebs);
                maleGame.shuffle();
                maleGame.printCandidates();
                maleGame.playGame();
            } else {
                FemaleMatchGame femaleGame = new FemaleMatchGame(femaleCelebs);
                femaleGame.shuffle();
                femaleGame.printCandidates();
                femaleGame.playGame();
            }
        } catch (NumberFormatException e) {
            System.err.println(new InvalidGenderException(">> 숫자만 입력하세요! (1 또는 2)").getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
