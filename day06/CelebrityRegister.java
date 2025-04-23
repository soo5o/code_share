package test.day06;

import java.util.*;

public class CelebrityRegister {
    public static void main(String[] args) {
        List<MaleCelebrity> maleCelebrities = new ArrayList<>();
        List<FemaleCelebrity> femaleCelebrities = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("남자 연예인 몇 명 등록할까요? ");
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; ) {
            System.out.print("이름 입력: ");
            String name = sc.nextLine();
            try {
                MaleCelebrity newCeleb = new MaleCelebrity(name);
                if (maleCelebrities.contains(newCeleb)) {
                    System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                    continue;
                }
                maleCelebrities.add(newCeleb);
                i++;
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("여자 연예인 몇 명 등록할까요? ");
        num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; ) {
            System.out.print("이름 입력: ");
            String name = sc.nextLine();
            try {
                FemaleCelebrity newCeleb = new FemaleCelebrity(name);
                if (femaleCelebrities.contains(newCeleb)) {
                    System.out.println(">> 중복된 이름입니다. 등록하지 않습니다.");
                    continue;
                }
                femaleCelebrities.add(newCeleb);
                i++;
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }
        }

        // 출력
        System.out.println("\n[남자 연예인 리스트]");
        for (MaleCelebrity celeb : maleCelebrities) {
            System.out.println(celeb);
        }

        System.out.println("\n[여자 연예인 리스트]");
        for (FemaleCelebrity celeb : femaleCelebrities) {
            System.out.println(celeb);
        }
    }
}
