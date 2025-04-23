package day06;

import java.text.SimpleDateFormat;
import java.util.*;

public class WinnerAnnouncer {
    //    우승자 이름 출력
//    멘트 랜덤 출력 (getRandomComment() 메서드 사용)
//    날짜 포맷 선택 (getDateFormatChoice(), formatDate() 메서드 사용)
//    시스템 정보 필터링 후 정렬 출력 (printSystemInfo() 메서드 사용)
    String[] finalComment = {"운명적인 만남! 👑",
            "불꽃 튀는 승부! 🔥",
            "눈부신 이상형입니다! 🌟",
            "모두가 인정한 최강 이상형! 🏆",
            "세상에 이런 이상형이?! ⭐",
            "만장일치! 역대급 이상형 탄생! 🍻",
            "찢었다! 레전드 우승자! 💥",
            "마음 속 1픽, 오늘도 나의 선택은 당신! 💞",
            "심사위원장이 소름 돋았다네요… 🥶",
            "우승자의 미모에 심사위원장 쓰러짐 😵‍💫",
            "태어날 때부터 월드컵 우승자였던 사람 😎",
            "시작도 전에 결승전 확정된 이상형! 🚀",
            "치명적인 매력… 모두를 홀렸다! 🧲",
            "이건 신이 선택한 이상형입니다… 👼🏻",
            "이상형 월드컵 역사상 최초! 완벽한 우승자! 🎖️",
            "심사위원장: '솔직히 이 사람 나도 찍었다' 🫢",
            "상대팀 모두 GG 선언하고 퇴장 😢",
            "오늘부터 내 배경화면 예약 📱",
            "다음 시즌 결승 진출권 자동 확보 🤣",
            "사람인가, 조각인가… 🗿"};

    public void printWinnerSummary(Celebrity winner) {
        Scanner sc = new Scanner(System.in);
        //이 메서드 안에서 멘트, 날짜, 시스템 정보 모두 출력.
        Random random = new Random();
        System.out.println("\n✨ 오늘의 멘트: " + finalComment[random.nextInt(finalComment.length)]);
        System.out.print("\n날짜 포맷을 선택하세요:\n" +
                "1. yyyy년 MM월 dd일 HH시 mm분 ss초\n" +
                "2. yyyy-MM-dd'T'HH:mm:ss (ISO 포맷)\n" +
                "3. yyyy/MM/dd HH:mm:ss (사용자 포맷)\n"
        );
        while (true) {
            try {
                System.out.print("선택: ");
                int option = Integer.parseInt(sc.nextLine());
                if (!(option == 1 || option == 2 || option == 3)) {
                    System.out.println("잘못된 입력입니다! 1, 2, 3 중 하나의 값만 입력하세요.");
                    continue;
                }
                Date now = new Date();
                SimpleDateFormat sdf;
                if (option == 1) {
                    sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
                } else if (option == 2) {
                    sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                } else {
                    sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                }
                System.out.println("\n\uD83D\uDCC5 발표 날짜:");
                System.out.println(sdf.format(now));
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다! 1, 2, 3 중 하나의 값만 입력하세요.");
            }
        }
        System.out.println("\n\uD83D\uDCBB 시스템 정보:");
        Properties props = System.getProperties();
        List<String> javaKeys = new ArrayList<>();

        // keySet에서 "java."로 시작하는 key만 골라서 리스트에 추가
        for (String key : props.stringPropertyNames()) {
            if (key.startsWith("java.")) {
                javaKeys.add(key);
            }
        }
        Collections.sort(javaKeys);
        for (String key : javaKeys) {
            System.out.println(key + " = " + props.getProperty(key));
        }
    }
}
