package study.programmers.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        Pattern pattern = Pattern.compile("\\d{1,2}[SDT]([*#])?");
        Matcher matcher = pattern.matcher(dartResult);
        int prevScore = 0;
        while (matcher.find()) {
            String result = matcher.group();
            Score score = new Score(result);
            int realScore = score.calculateScore();
            answer += realScore;
            if (score.isStar()) {
                answer += prevScore;
            }
            prevScore = realScore;
        }

        return answer;
    }
}

class Score {
    private final int score;
    private final char bonus;
    private char option;

    public Score(String result) {
        score = Integer.parseInt(result.split("[SDT]")[0]);
        String[] bonusAndOption = result.split("\\d{1,2}");
        bonus = bonusAndOption[1].charAt(0);
        if (bonusAndOption[1].length() > 1) {
            option = bonusAndOption[1].charAt(1);
        }
    }

    public int calculateScore() {
        int realScore = score;

        if (bonus == 'D') {
            realScore *= score;
        }
        if (bonus == 'T') {
            realScore *= score * score;
        }

        if (option == '*') {
            return realScore * 2;
        }

        if (option == '#') {
            return realScore * -1;
        }

        return realScore;
    }

    public boolean isStar() {
        return option == '*';
    }
}
