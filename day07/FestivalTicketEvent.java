package test.day07;

public class FestivalTicketEvent extends AbstractTicketEvent {
    public FestivalTicketEvent(int ticketCount) {
        super(ticketCount);
    }

    @Override
    protected void fanEntry() {
        Thread[] fans = new Thread[ticketCount];
        for (int i = 0; i < ticketCount; i++) {
            final int fanNumber = i + 1;
//            fans[i] = new Thread(() -> {
//                Thread.currentThread().setName("팬" + fanNumber);
//                System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
//            });
            fans[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 티켓 구매 시도 중!");
                }
            }, "팬" + fanNumber);

        }
        for (Thread fan : fans) {
            fan.start();
        }
        // 모든 팬 스레드가 끝날 때까지 대기
        for (Thread fan : fans) {
            try {
                fan.join(); // 스레드 종료 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
