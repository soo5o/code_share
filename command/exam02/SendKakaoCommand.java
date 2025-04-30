package command.exam02;

public class SendKakaoCommand implements Command{
    @Override
    public void execute(Message message) {
        System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
    }
}
