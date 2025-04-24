package test.day07;

public class TicketingRound2 {
    public static void main(String[] args) {
        AbstractTicketEvent event = new FestivalTicketEvent(5);
        event.startEvent();  // 템플릿 메서드 실행
    }
}
