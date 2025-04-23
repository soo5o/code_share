package day06;

import java.text.SimpleDateFormat;
import java.util.*;

public class HistoryManager {
    private List<String> saveResult = new ArrayList<>();

    public void saveSelection(int round, Celebrity c1, Celebrity c2, Celebrity winner, boolean isFinal) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strRound = isFinal ? "결승" : round + "라운드";
        String msg = "[" + strRound + "] " + c1.getName() + " vs " + c2.getName() + " → 선택: " + winner.getName() + " (" + sdf.format(now) + ")";
        saveResult.add(msg);
    }

    public void showSelectionHistory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\uD83D\uDCC2 히스토리를 어떤 순서로 볼까요?\n" +
                "1. 최근 선택부터 (Stack: 후입선출)\n" +
                "2. 오래된 선택부터 (Queue: 선입선출)\n" +
                "선택: ");
        int option = Integer.parseInt(sc.nextLine());

        System.out.println("=== [히스토리] ===");
        if (option == 1) {
            Stack<String> stack = new Stack<>();
            stack.addAll(saveResult);
            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        } else if (option == 2) {
            Queue<String> q = new ArrayDeque<>();
            q.addAll(saveResult);
            while (!q.isEmpty()) {
                System.out.println(q.remove());
            }

        } else {
            System.out.println("잘못된 입력입니다! 1 또는 2만 입력하세요.");
        }
    }
}
