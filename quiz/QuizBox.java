package test.day08.quiz;

import java.util.Arrays;

public class QuizBox<T extends Content> {
    Object[] list;    //문제들을 저장하는 배열
    private int size;

    @SuppressWarnings("unchecked")
    public QuizBox() {
        list = (T[]) new Quiz[5]; // 초기 크기 5
        size = 0;
    }

//    public void addQuiz(T quiz) {
//        if (size >= list.length) {
//            list = Arrays.copyOf(list, list.length * 2); // 크기 자동 확장
//        }
//        list[size++] = quiz;
//    }

    // 긴 문자열을 받아서 줄(line) 단위로 나누고, 문제/정답을 추출하여 추가
//    public void addQuizFromString(String text) {
//        String[] lines = text.split("\r?\n"); // 줄 단위로 나누기
//        for (String line : lines) {
//            String[] parts = line.split(" - ");
//            if (parts.length == 2) { // 문제와 정답이 모두 있어야 추가
//                String question = parts[0].trim();
//                String answer = parts[1].trim();
//                addQuiz((T) new Quiz(question, answer)); // Quiz 객체 만들어 추가
//            }
//        }
//    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            T quiz = (T) list[i];
            System.out.println((i + 1) + ". " + quiz);
        }
    }

    public void add(T content) {    //배열에 문제 추가 (필요 시 배열 크기 2배 확장)
        if (size >= list.length) {
            list = Arrays.copyOf(list, list.length * 2); // 크기 자동 확장
        }
        list[size++] = content;
    }

    public boolean remove(Content content) { //문제 제목이 같은 객체를 찾아 삭제
        for (int i = 0; i < size; i++) {
            if (list[i].equals(content)) {
                // 뒤에 있는 요소들을 앞으로 땡겨서 삭제 처리
                for (int j = i; j < size - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[--size] = null; // 마지막 요소 제거
                return true;
            }
        }
        return false;
    }

    public static <T extends Content> void removeFromBox(QuizBox<? super T> box, T quiz) {   //다른 박스에서 문제를 삭제하는 메소드

        if (box.remove(quiz)) {
            System.out.println("삭제 성공: " + quiz.getQuestion());
        }
    }
}
