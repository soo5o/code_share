package day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class MatchGame implements VsSelectable {
    protected Celebrity[] candidates;

    public abstract void initializeCandidates();

    public Celebrity playGame() {
        int round = 0;
        HistoryManager historyManager = new HistoryManager();
        while (candidates.length > 1) {
            System.out.printf("\n======== 라운드 %d ========\n", ++round);
            List<Celebrity> nextRound = new ArrayList<>();
            if (candidates.length % 2 == 0) {
                // 짝수일 경우 인접한 두 후보끼리 대결
                for (int i = 0; i < candidates.length; i += 2) {
                    Celebrity winner = selectWinner(candidates[i], candidates[i + 1]);
                    nextRound.add(winner);
                    boolean isFinal = (candidates.length == 2);
                    historyManager.saveSelection(round, candidates[i], candidates[i + 1], winner, isFinal);
                }
            } else {
                // 홀수일 경우 마지막 후보는 자동 진출
                for (int i = 0; i < candidates.length - 1; i += 2) {
                    Celebrity winner = selectWinner(candidates[i], candidates[i + 1]);
                    nextRound.add(winner);
                    boolean isFinal = (candidates.length == 2);
                    historyManager.saveSelection(round, candidates[i], candidates[i + 1], winner, isFinal);
                }
                System.out.println(candidates[candidates.length - 1].getName() + "은(는) 자동으로 다음 라운드 진출!");
                nextRound.add(candidates[candidates.length - 1]);
            }
            candidates = nextRound.toArray(new Celebrity[0]);
        }
        Celebrity finalWinner = candidates[0];
        System.out.println("🏆 최종 우승자: " + finalWinner.getName());
        WinnerAnnouncer announcer = new WinnerAnnouncer();
        announcer.printWinnerSummary(finalWinner);
        historyManager.showSelectionHistory();
        return finalWinner;
    }

    public void printCandidates() {
        for (Celebrity celebrity : candidates) {
            System.out.println(celebrity);
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = candidates.length - 1; i > 0; i--) {
            int randomIdx = random.nextInt(i + 1);
            Celebrity temp = candidates[i];
            candidates[i] = candidates[randomIdx];
            candidates[randomIdx] = temp;
        }
    }

    @Override
    public Celebrity selectWinner(Celebrity c1, Celebrity c2) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("둘 중 누가 더 이상형인가요?");
                System.out.println("1. " + c1.getName());
                System.out.println("2. " + c2.getName());
                System.out.print("선택: ");
                int winner = Integer.parseInt(sc.nextLine());
                if (winner == 1) {
                    System.out.println("[" + c1.getName() + " 우승 ! ]");
                    return c1;
                }
                if (winner == 2) {
                    System.out.println("[" + c2.getName() + " 우승 ! ]");
                    return c2;
                }
                System.out.println("잘못된 입력입니다! 1 또는 2만 입력하세요.");
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다! 1 또는 2만 입력하세요.");
            }
        }
    }
}