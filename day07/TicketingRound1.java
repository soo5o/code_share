package test.day07;

import lombok.Data;

@Data
public class TicketingRound1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
            }
        });
        thread1.setName("팬1");
        thread2.setName("팬2");
        System.out.println("=== run() 직접 호출 테스트 ===");
        thread1.start();
        thread1.run();
        thread2.start();
    }

}
