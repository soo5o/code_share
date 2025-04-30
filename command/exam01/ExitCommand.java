package command.exam01;

import java.util.Scanner;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("종료할까요? (y/n)");
        String ans = sc.nextLine();
        sc.close();
        if(ans.isEmpty() || ans.equalsIgnoreCase("y")){
            //equalsIgnoreCase: 대소문자 구분 없이 현재 문자열과 anotherString 이 같은지 비교
            System.exit(0);
        }
    }
}
