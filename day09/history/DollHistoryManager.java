package test.day09.history;

import java.util.*;

public class DollHistoryManager {
    // 고객별 인형 기록을 관리하는 새로운 클래스
    Map<String, List<String>> historyMap = new HashMap<>();

    //Map<String, List<String>> historyMap = new HashMap<>(); //초기화 필요?
    public void addHistory(String customer, String doll) {
        if (!historyMap.containsKey(customer)) {
            historyMap.put(customer, new ArrayList<>());
        }
        historyMap.get(customer).add(doll);
        System.out.println("\uD83D\uDCD2 " + customer + " 님의 인형 기록에 '" + doll + "'이 추가되었습니다.");
    }

    public void showAllHistory() {
        if (historyMap.isEmpty()) {
            System.out.println("\uD83D\uDCCB 아직 기록된 고객이 없습니다.");
            return;
        }
        Set<String> keySet = historyMap.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String name = keyIterator.next();
            System.out.println("- " + name + ":" + historyMap.get(name));
        }
    }

    public void showAllUniqueHistory() {
        System.out.println("\uD83C\uDF81 중복 인형 제거 이벤트 결과:");
        for (String name : historyMap.keySet()) {
            //Set<String> unique = new LinkedHashSet<>(historyMap.get(name)); // 입력 순서 유지
            Set<String> unique = new HashSet<>(historyMap.get(name));
            Iterator<String> it = unique.iterator();
            //System.out.println("- " + name + ": " + unique);

            StringBuilder sb = new StringBuilder();
            sb.append("- ").append(name).append(": [");

            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }

            sb.append("]");
            System.out.println(sb);
        }
    }
}

