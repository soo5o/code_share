package day06;

public class InvalidNameException extends Exception {
    public InvalidNameException() {
        super("이름은 한글 2~10자여야 합니다!");
    }
}
