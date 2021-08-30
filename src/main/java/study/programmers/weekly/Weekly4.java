package study.programmers.weekly;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/84325?language=java
 * 2021-08-27
 */

public class Weekly4 {

  static class Language {
    private String name;
    private int score;

    public Language(String name, int score) {
      this.name = name;
      this.score = score;
    }

    public String getName() {
      return name;
    }

    public int getScore() {
      return score;
    }
  }

  public String solution(String[] table, String[] languages, int[] preference) {

    Map<String, Integer> languagePreferenceMap = new HashMap<>();

    for (int i = 0; i < languages.length; i++) {
      languagePreferenceMap.put(languages[i], preference[i]);
    }

    Language[] languageArray = new Language[table.length];

    for (int i = 0; i < table.length; i++) {
      String[] constents = table[i].split(" ");
      String title = constents[0];
      int sum = 0;
      for (int j = 1; j < constents.length; j++) {
        if (languagePreferenceMap.containsKey(constents[j])) {
          sum += languagePreferenceMap.get(constents[j]) * (constents.length - j);
        }
      }
      languageArray[i] = new Language(title, sum);
    }

    Arrays.sort(languageArray, (l1, l2) -> {
      String name1 = l1.getName();
      int score1 = l1.getScore();
      String name2 = l2.getName();
      int score2 = l2.getScore();

      if(score1 == score2){
        return name1.compareTo(name2);
      }else {
        return score2 - score1;
      }
    });

    return languageArray[0].getName();
  }
}
