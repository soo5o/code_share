package test.day08.quiz;

public class QuizNode {
    public String title; //문제 제목을 저장한다.
    public String content; //문제 내용을 저장한다.
    public QuizNode next; //다음 문제를 가리키는 포인터를 가진다.

    public QuizNode(String title, String content, QuizNode next) {
        this.title = title;
        this.content = content;
        this.next = next;
    }
}
