package test.day07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EntryManager {
    private Stack<Fan> vipStack = new Stack<>();
    private Queue<Fan> normalQueue = new LinkedList<>();
    private int ticketCount;

    public EntryManager(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public void registerFan(Fan fan) {
        if (fan.isVIP()) {
            //Stack → LIFO
            vipStack.push(fan);
        } else {
            //Queue → FIFO
            normalQueue.offer(fan);
        }
    }

    synchronized public boolean processEntry(Fan fan) {
        if (ticketCount <= 0) return true; // 티켓 없으면 재도전하지 않게 함
        if (!vipStack.isEmpty()) {
            if (fan.isVIP() && vipStack.peek().getName().equals(fan.getName())) {
                vipStack.pop(); // 스택에서 제거
                ticketCount--;
                fan.entranceMessage("VIP " + fan.getName() + " 입장 완료!");
                return true;
            }
        } else if (!normalQueue.isEmpty()) {
            if (!fan.isVIP() && normalQueue.peek().getName().equals(fan.getName())) {
                normalQueue.poll(); // 큐에서 제거
                ticketCount--;
                fan.entranceMessage(fan.getName() + " 입장 완료!");
                return true;
            }
        }
        return false; // 입장 실패 → 재도전
    }
}
