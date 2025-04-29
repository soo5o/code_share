package test.day08.quiz;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QuizIterator implements Iterator<QuizNode> {
    private QuizNode current;

    public QuizIterator(QuizNode head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public QuizNode next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        QuizNode result = current;
        current = current.next;
        return result;
    }
}

