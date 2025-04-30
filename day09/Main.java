package test.day09;

import test.day09.history.DollHistoryManager;
import test.day09.popularity.DollPopularityManager;
import test.day09.queue.DollQueueManager;
import test.day09.stack.DollStackManager;
import test.day09.util.RandomCustomerProvider;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  메뉴 출력, 사용자 입력 처리, 전체 흐름 관리
        Scanner sc = new Scanner(System.in);
        DollQueueManager dollQueueManager = new DollQueueManager();
        DollStackManager dollStackManager = new DollStackManager();
        DollHistoryManager dollHistoryManager = new DollHistoryManager();
        DollPopularityManager popularityManager = new DollPopularityManager();
        menu();
        while (true) {
            System.out.print("선택 >> ");
            int sel = sc.nextInt();
            switch (sel) {
                case 1:
                    String name = RandomCustomerProvider.getRandomCustomer();
                    dollQueueManager.registerCustomer(name);
                    break;
                case 2:
                    String customer = dollQueueManager.getNextCustomer();
                    if (customer == null) {
                        break;
                    }
                    String doll = dollStackManager.storeRandomDoll();
                    dollHistoryManager.addHistory(customer, doll);
                    popularityManager.addDoll(doll);
                    System.out.println("\uD83D\uDC49 " + customer + " 님, 한 번 더 뽑으시겠습니까? (y/n): ");
                    sc.nextLine(); // 버퍼 비우기
                    String ans = sc.nextLine();
                    if (ans.equalsIgnoreCase("y")) {
                        dollQueueManager.registerCustomer(customer);
                        System.out.println("\uD83D\uDD01 " + customer + " 님이 다시 대기열에 등록되었습니다.");
                    } else {
                        System.out.println("\uD83D\uDC49 " + customer + " 님, 뽑기가 종료됩니다.");
                    }
                    break;
                case 3:
                    dollQueueManager.showWaitingList();
                    break;
                case 4:
                    dollStackManager.showStack();
                    break;
                case 5:
                    dollHistoryManager.showAllHistory();
                    break;
                case 6:
                    dollHistoryManager.showAllUniqueHistory();
                    break;
                case 7:
                    popularityManager.showRanking();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("옵션을 다시 선택해주세요.");
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("=== 유라의 인형뽑기 가게 ===");
        System.out.println("[1] 고객 등록\n" +
                "[2] 뽑기 진행 (보관 + 기록)\n" +
                "[3] 현재 대기열 보기\n" +
                "[4] 보관함 보기\n" +
                "[5] 고객별 인형 기록 보기\n" +
                "[6] 중복 제거된 인형 목록 보기\n" +
                "[7] 인형별 인기 순위 보기\n" +
                "[0] 종료");
    }
}
