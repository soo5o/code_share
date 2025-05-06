package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<QuizNode> correct = new ArrayList<>();
        List<String> wrong = new ArrayList<>();
        String data = """
                초인종이 없을 때를 두 글자로 줄이면? - 노벨
                보라돌이 나나 뽀가 자기들끼리 식사할 때 두비가 하는 말은? - 뚜비두밥
                등산을 좋아하는 왕은? - 하이킹
                고등학생이 싫어하는 나무는? - 야자나무
                포도가 자기소개할 때 하는 말은? - 포도당
                신데렐라가 잠을 못 자면? - 모짜렐라
                <옷장 안에 불이 났다>를 다섯 글자로 하면? - 장안의 화재
                호랑이가 차를 타고 가다가 친구를 만나서 하는 말은? - 타이거
                몸이 아파도 반드시 가야 하는 대학교는? - 가야대
                인사하면서 웃으면? - 하이킥
                자동차를 톡하고 치면? - 카톡
                <이것이 코다>를 세 글자로 줄이면? - 디스코
                소녀가 강으로 여행을 가면? - 걸리버 여행
                소고기가 없는 나라는? - 소고기무국
                드라큘라가 가장 싫어하는 사람은? - 찔러도 피 안 나는 사람
                때돈을 버는 곳은? - 목욕탕
                자동차 키 색은? - 카키색
                해와 달 중, 해만 취재하는 사람은? - 해리포터
                입이 S자로 되어있으면? - EBS
                신문이 일하러 가면? - 일간신문
                """;
        Scanner sc = new Scanner(System.in);
        QuizLinkedList quizList = new QuizLinkedList();
        String[] quiz = data.split("\n");
        for (String q : quiz) {
            String[] qa = q.split("-");
            quizList.addLast(qa[0].trim(), qa[1].trim());  //문제 저장
        }
        ArrayList<QuizNode> quizArray = new ArrayList<>();
        for (QuizNode node : quizList) {
            quizArray.add(node);
        }

        // 2단계: 문제 섞기
        Collections.shuffle(quizArray);
        int total = quizList.size();

        for (int i = 0; i < total; i++) {
            QuizNode node = quizArray.get(i);
            System.out.printf("\n[%d/%d] 문제: %s\n", i + 1, total, node.title);
            System.out.print("답변 입력: ");
            String ans = sc.nextLine().trim();

            if (ans.equalsIgnoreCase(node.answer)) {
                System.out.println("정답입니다!");
                correct.add(node);
            } else {
                System.out.println("오답입니다! (정답: " + node.answer + ")");
                String w = node.title + "-" + ans;
                wrong.add(w);
            }
        }
        System.out.println("=== 맞춘 문제 목록 ===");
        for (QuizNode c : correct) {
            System.out.println("문제: " + c.title);
            System.out.println("정답: " + c.answer);
        }
        System.out.println("=== 틀린 문제 목록 ===");
        for (String w : wrong) {
            String[] ww = w.split("-");
            System.out.println("문제: " + ww[0]);
            System.out.println("내 답변: " + ww[1]);
        }
        System.out.println("=== 최종 결과 ===");
        System.out.printf("총 %d문제 중 %d문제 정답!\n", total, correct.size());
        System.out.printf("정답률: %d%%\n", (correct.size() * 100 / total));
    }
}
