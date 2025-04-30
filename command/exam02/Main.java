package command.exam02;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Map<String, Command> commands = new LinkedHashMap<>();
        commands.put("sendMail", new SendMailCommand());
        commands.put("sendSMS", new SendSMSCommand());
        commands.put("sendKakaotalk", new SendKakaoCommand());
        Queue<Message> messageQueue = new LinkedList<>();
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "김자바"));
        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();
            //Command 호출
           Command command = commands.get(message.command);
           if(command != null){
               command.execute(message);
           }
        }
    }
}
