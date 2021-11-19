package study.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class RankSearch {
    public static final String AND_SEPARATOR = " and ";
    public static final String BLANK_SEPARATOR = " ";

    public int[] solution(String[] info, String[] query) {
        CandidateList candidateList = new CandidateList(info);
        return Arrays.stream(query).mapToInt(q -> {
                String[] options = q.split(AND_SEPARATOR);
                String[] soulFoodAndScore = options[3].split(BLANK_SEPARATOR);
                return candidateList.countBy(options[0],
                    options[1],
                    options[2],
                    soulFoodAndScore[0],
                    Integer.parseInt(soulFoodAndScore[1]));
            }
        ).toArray();
    }
}

class Candidate {
    public static final String BLANK_SEPARATOR = " ";
    public static final String DASH = "-";
    private final String language;
    private final String type;
    private final String career;
    private final String soulFood;
    private final int score;

    public Candidate(String info) {
        String[] infos = info.split(BLANK_SEPARATOR);
        language = infos[0];
        type = infos[1];
        career = infos[2];
        soulFood = infos[3];
        score = Integer.parseInt(infos[4]);
    }

    public int getScore() {
        return score;
    }

    public List<String> getKey() {

        ArrayList<String> keys = new ArrayList<>();
        String[] languageArr = {DASH, language};
        String[] typeArr = {DASH, type};
        String[] careerArr = {DASH, career};
        String[] soulFoodArr = {DASH, soulFood};

        for (String l : languageArr) {
            for (String t : typeArr) {
                for (String c : careerArr) {
                    for (String s : soulFoodArr) {
                        keys.add(l + BLANK_SEPARATOR + t + BLANK_SEPARATOR + c + BLANK_SEPARATOR + s);
                    }
                }
            }
        }

        return keys;
    }
}

class CandidateList {
    public static final String BLANK_SEPARATOR = " ";
    private final Map<String, ArrayList<Integer>> candidateMap;

    public CandidateList(String[] info) {
        List<Candidate> candidateList = Arrays.stream(info)
            .map(Candidate::new)
            .collect(Collectors.toList());
        candidateMap = new HashMap<>();
        for (Candidate candidate : candidateList) {
            for (String key : candidate.getKey()) {
                ArrayList<Integer> candidates = candidateMap.get(key);

                if (candidates == null) {
                    candidates = new ArrayList<>();
                }
                candidates.add(candidate.getScore());

                candidateMap.put(key, candidates);
            }
        }
        for (ArrayList<Integer> scoreList : candidateMap.values()) {
            Collections.sort(scoreList);
        }
    }

    public int countBy(
        String language,
        String type,
        String career,
        String soulFood,
        int score
    ) {
        List<Integer> candidates = candidateMap.get(language + BLANK_SEPARATOR + type + BLANK_SEPARATOR + career + BLANK_SEPARATOR + soulFood);

        if (candidates == null) {
            return 0;
        }
        return candidates.size() - firstIndexOf(candidates, score);
    }

    // lower bound
    private int firstIndexOf(List<Integer> candidates, int score) {
        int min = 0;
        int max = candidates.size();
        int mid;
        while (min < max) {
            mid = (min + max) / 2;
            if (candidates.get(mid) < score) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
}
