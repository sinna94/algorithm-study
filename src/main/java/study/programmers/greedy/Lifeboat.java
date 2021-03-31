package study.programmers.greedy;

/*
 * 2021-03-31
 * https://programmers.co.kr/learn/courses/30/lessons/42885?language=java
 */

import java.util.Arrays;

public class Lifeboat {
  public int solution(int[] people, int limit) {
    int answer = 0;

    Arrays.sort(people);

    int firstIndex = 0;
    int secondIndex = people.length - 1;
    while (firstIndex < secondIndex) {

      if (people[firstIndex] + people[secondIndex] <= limit) {
        firstIndex += 1;
      }
      secondIndex -= 1;
      answer += 1;
    }

    if (firstIndex == secondIndex) {
      answer += 1;
    }

    return answer;
  }
}
