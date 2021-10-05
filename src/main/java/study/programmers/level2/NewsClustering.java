package study.programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 * 2021-10-5
 */
public class NewsClustering {
    public int solution(String str1, String str2) {
        return (int) (calculateJaccardSimilarity(str1, str2) * 65536);
    }

    private double calculateJaccardSimilarity(String str1, String str2) {
        Map<String, Long> set1ElementCountMap = getElementCountMap(str1.toLowerCase());
        Map<String, Long> set2ElementCountMap = getElementCountMap(str2.toLowerCase());

        if (set1ElementCountMap.isEmpty() && set2ElementCountMap.isEmpty()) {
            return 1.0;
        }

        int intersectionSize = intersection(set1ElementCountMap, set2ElementCountMap);
        long unionSize = union(set1ElementCountMap, set2ElementCountMap);
        return intersectionSize / (double) unionSize;
    }

    private int union(Map<String, Long> set1ElementCountMap, Map<String, Long> set2ElementCountMap) {
        Map<String, Long> copiedMap = new HashMap<>(set2ElementCountMap);

        set1ElementCountMap.forEach((key, value) -> {
                Long set2ElementCount = set2ElementCountMap.getOrDefault(key, 0L);
                copiedMap.put(key, Math.max(value, set2ElementCount));
            }
        );

        return copiedMap.values().stream()
            .mapToInt(Long::intValue).sum();
    }

    private Map<String, Long> getElementCountMap(String str) {
        return IntStream.range(0, str.length() - 1)
            .mapToObj(index -> str.substring(index, index + 2))
            .filter(this::predicateOnlyAlphabet)
            .collect(Collectors.groupingBy(element -> element, Collectors.counting()));
    }

    private int intersection(Map<String, Long> set1ElementCountMap, Map<String, Long> set2ElementCountMap) {
        return set1ElementCountMap.entrySet().stream()
            .filter(entry -> set2ElementCountMap.containsKey(entry.getKey()))
            .map(entry -> Math.min(entry.getValue(), set1ElementCountMap.get(entry.getKey())))
            .mapToInt(Long::intValue)
            .sum();
    }

    private boolean predicateOnlyAlphabet(String element) {
        return element.matches("[A-Z|a-z]{2}");
    }
}
