package test.day08.quiz;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class QuizLinkedList implements Iterable<QuizNode> {
    QuizNode head;   // 첫 번째 문제를 가리킨다.

    public QuizLinkedList() {
        System.out.println("=== 현재 도전할 문제 리스트 ===");
    }

    public void addLast(String title, String content) {
        QuizNode newNode = new QuizNode(title, content, null);

        if (head == null) {
            head = newNode;
        } else {
            QuizNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printAll() {
        QuizNode current = head;
        while (current != null) {
            System.out.println("문제 제목: " + current.title);
            System.out.println("문제 내용: " + current.content);
            System.out.println();
            current = current.next;
        }
    }

    void addFirst(String title, String content) {
        //리스트 맨 앞에 문제를 추가하는 메서드
        QuizNode newNode = new QuizNode(title, content, head);
        head = newNode;
    }

    void removeFirst() {
        //리스트의 맨 앞 문제를 삭제하는 메서드 → 리스트가 비어 있다면 아무것도 하지 않는다.
        if (head == null) {
            return;
        }
        head = head.next;
    }

    void addAt(int index, String title, String content) {
        QuizNode newNode = new QuizNode(title, content, null);

        if (index <= 0 || head == null) {
            // 인덱스가 0 이하이거나 리스트가 비었을 경우 맨 앞에 추가
            newNode.next = head;
            head = newNode;
            return;
        }

        QuizNode current = head;
        int i = 0;

        // 인덱스 바로 앞 노드 찾기
        while (current.next != null && i < index - 1) {
            current = current.next;
            i++;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    int size() {
        int s = 0;
        QuizNode current = head;
        while (current != null) {
            s++;
            current = current.next;
        }
        return s;
    }

    @Override
    public Iterator<QuizNode> iterator() {
        //iterator() 메서드를 오버라이드하여 QuizIterator 객체를 반환한다.
        return new QuizIterator(head);
    }

    @Override
    public void forEach(Consumer<? super QuizNode> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<QuizNode> spliterator() {
        return Iterable.super.spliterator();
    }
}
