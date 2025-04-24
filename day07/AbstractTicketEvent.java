package test.day07;

public abstract class AbstractTicketEvent {
    protected int ticketCount;

    public AbstractTicketEvent(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public final void startEvent() {
        openAnnouncement(); // → "이벤트 시작! 남은 티켓: ○장" 출력
        fanEntry(); // → 팬 스레드 생성 (자식 클래스가 구현)
        closingAnnouncement(); // → "이벤트 종료! 모두 수고하셨습니다 :짠:"
    }

    protected abstract void fanEntry();

    private void openAnnouncement() {
        System.out.println("이벤트 시작! 남은 티켓: " + ticketCount + "장");
    }

    private void closingAnnouncement() {
        System.out.println("이벤트 종료! 모두 수고하셨습니다 🎉");
    }
}
