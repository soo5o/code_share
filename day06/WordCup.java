package test.day06;

import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("참가자 이름을 입력하세요: ");
        String name = sc.nextLine();

        if (Pattern.matches("^[가-힣]{2,10}$", name)) {
            System.out.println("다음 단계로 진행합니다.");
        } else {
            System.out.print("😡 탈락! 잘못된 이름입니다: ");
            InvalidNameException e = new InvalidNameException();
            System.out.println(e.getMessage()); // 예외 메시지를 직접 출력
        }
    }
}
