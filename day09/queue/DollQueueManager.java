package test.day09.queue;

import java.util.LinkedList;
import java.util.Queue;

public class DollQueueManager {
    //대기열 관리 기능 제공 (등록/제거/조회)
    private Queue<String> queue = new LinkedList<>();

    public void registerCustomer(String name) { // 고객 등록
        queue.add(name);
        System.out.println("👉🏻 " + name + " 님이 대기열에 등록되었습니다.");
    }

    public void processNextCustomer(String name) {   // 첫 고객 뽑기 실행
        System.out.println("🎉 " + name + "님! 인형 뽑기 하러 오세요!"); //poll 수정하기
    }

    public void showWaitingList() {      // 현재 대기열 출력
        if (queue.isEmpty()) {
            System.out.println("\uD83E\uDDFE 현재 대기열은 비어있습니다.");
            return;
        }
        System.out.println("\uD83E\uDDFE 현재 대기열: " + queue);
    }

    public String getNextCustomer() {
        if (queue.isEmpty()) {
            System.out.println("\uD83E\uDDFE 현재 대기 인원이 없습니다.");
            return null;
        }
        String name = queue.poll();
        processNextCustomer(name);
        return name;
    }
}
