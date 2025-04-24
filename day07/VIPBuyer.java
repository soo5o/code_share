package test.day07;

public class VIPBuyer implements TicketBuyer {
    @Override
    public void buyTicket() {

    }

    @Override
    public void waitTurn() {
        try {
            Thread.sleep(10); // 스레드 종료 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void entranceMessage(String name) {
        System.out.println("VIP " + name + "입장 완료!");
    }
}
