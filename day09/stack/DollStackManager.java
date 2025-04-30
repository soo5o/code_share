package test.day09.stack;

import java.util.Random;
import java.util.Stack;

public class DollStackManager {
    private String[] dolls = {"피카츄", "리자몽", "꼬부기", "쿠로미", "헬로키티",
            "뽀로로", "짱구", "도라에몽", "스폰지밥", "미니언"};
    private Stack<String> stack = new Stack<>();

    public String storeRandomDoll() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(dolls.length);
        stack.push(dolls[randomIndex]);
        System.out.println("\uD83E\uDDF8 " + dolls[randomIndex] + "인형이 보관함에 추가되었습니다.");
        return dolls[randomIndex];
    }

    public void showStack() {
        if (stack.isEmpty()) {
            System.out.println("\uD83E\uDDF8 현재 보관 중인 인형이 없습니다.");
        }
        System.out.println("\uD83E\uDDF8 현재 보관 중인 인형: " + stack);
    }
}
