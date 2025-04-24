package test.day07;

public class TicketingRound3 {
    public static void main(String[] args) {
        EntryManager entryManager = new EntryManager(5);
        Fan[] fans = {
                new Fan("팬1", false, entryManager, new RegularBuyer()),
                new Fan("팬2", true, entryManager, new VIPBuyer()),
                new Fan("팬3", false, entryManager, new SlowBuyer()),
                new Fan("팬4", true, entryManager, new VIPBuyer()),
                new Fan("팬5", false, entryManager, new RegularBuyer())
        };
        int ticketCount = fans.length;
        System.out.println("이벤트 시작! 남은 티켓: " + ticketCount + "장");
        Thread[] threads = new Thread[fans.length];
        for (int i = 0; i < fans.length; i++) {
            threads[i] = new Thread(fans[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // 각 스레드가 끝날 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉");
    }
}
