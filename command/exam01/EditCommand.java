package command.exam01;

public class EditCommand implements Command{
    //lt + shift + enter: 메서드 구현
    @Override
    public void execute() {
        System.out.println("===================================");
        System.out.println("Edit Command");
        System.out.println("===================================");
        System.out.println();
    }
}
