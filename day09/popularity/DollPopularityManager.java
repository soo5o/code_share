package test.day09.popularity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DollPopularityManager implements Comparable {
    private Map<String, Integer> countMap = new HashMap<>();

    public void addDoll(String dollName) {
        countMap.put(dollName, countMap.getOrDefault(dollName, 0) + 1);
    }

    public void showRanking() {
        if (countMap.isEmpty()) {
            System.out.println("\uD83D\uDCCA 아직 뽑힌 인형이 없습니다.");
            return;
        }
        System.out.println("\uD83D\uDD25 인형별 인기 순위 (많이 뽑힌 순):");
        List<Map.Entry<String, Integer>> ranking = new ArrayList<>(countMap.entrySet());
        ranking.sort((e1, e2) -> {
            int compareCount = Integer.compare(e2.getValue(), e1.getValue()); // 내림차순
            if (compareCount != 0) return compareCount;
            return e1.getKey().compareTo(e2.getKey()); // 이름 오름차순
        });
        int rank = 1;
        for (Map.Entry<String, Integer> entry : ranking) {
            System.out.println(rank++ + ". " + entry.getKey() + " - " + entry.getValue() + "회");
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
