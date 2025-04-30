package test.day09;

import test.day09.command.*;
import test.day09.history.DollHistoryManager;
import test.day09.popularity.DollPopularityManager;
import test.day09.queue.DollQueueManager;
import test.day09.stack.DollStackManager;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DollQueueManager queueManager = new DollQueueManager();
        DollStackManager stackManager = new DollStackManager();
        DollHistoryManager historyManager = new DollHistoryManager();
        DollPopularityManager popularityManager = new DollPopularityManager();
        CommandInvoker invoker = new CommandInvoker();
        while (true) {
            System.out.println("\n=== 유라의 인형뽑기 가게 ===");
            System.out.println("[1] 고객 등록");
            System.out.println("[2] 뽑기 진행 (보관 + 기록)");
            System.out.println("[3] 현재 대기열 보기");
            System.out.println("[4] 보관함 보기");
            System.out.println("[5] 고객별 인형 기록 보기");
            System.out.println("[6] 중복 제거된 인형 목록 보기");
            System.out.println("[7] 인형별 인기 순위 보기");
            System.out.println("[0] 종료");
            System.out.print("선택 >> ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 숫자만 입력해주세요.");
                continue;
            }

            if (choice == 0) {
                System.out.println("👋 프로그램을 종료합니다.");
                break;
            }
            invoker.register(1, new RegisterCustomerCommand(queueManager));
            invoker.register(2, new PickDollCommand(queueManager, stackManager, historyManager, popularityManager));
            invoker.register(3, new ShowQueueCommand(queueManager));
            invoker.register(4, new ShowStackCommand(stackManager));
            invoker.register(5, new ShowHistoryCommand(historyManager));
            invoker.register(6, new ShowUniqueHistoryCommand(historyManager));
            invoker.register(7, new ShowRankingCommand(queueManager));

            invoker.execute(choice);
        }
    }
}
