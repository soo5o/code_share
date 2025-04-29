package test.day08.quiz;

public class Quiz extends Content {
    //문제와 정답을 관리하는 클래스
//    private String question;
    private String answer;

    public Quiz(String question, String answer) {
        super(question);
//        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
