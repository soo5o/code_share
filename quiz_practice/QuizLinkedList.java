package practice;

import java.util.*;

public class QuizLinkedList implements Iterable<QuizNode> { //문제 저장
    //문제 출제는 ArrayList로 변환한 후 Collections.shuffle()을 이용한다.
    ArrayList<QuizNode> quizList;
    private QuizNode head;

    public void addLast(String title, String answer) {//리스트 마지막에 문제 추가
        QuizNode newNode = new QuizNode(title, answer);
        if (head == null) { //첫 노드
            head = newNode;
        } else {
            QuizNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }

    public int size() { //현재 저장된 문제 개수 반환
        int s = 0;
        QuizNode current = head;
        while (current != null) {
            s++;
            current = current.next;
        }
        return s;
    }

    public Iterator<QuizNode> iterator() {
        return new QuizIterator(head);
    }
}
