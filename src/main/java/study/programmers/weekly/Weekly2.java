package study.programmers.weekly;
/*
 * 2021-08-10
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 */

import java.util.Arrays;

public class Weekly2 {
  public String solution(int[][] scores) {

    StringBuilder answer = new StringBuilder();

    for (int i = 0; i < scores.length; i++) {
      var count = scores.length;
      var sum = 0;
      var maxOrMin = isMaxOrMin(scores, i);

      for (int j = 0; j < scores.length; j++) {
        if (i == j && maxOrMin) {
          count -= 1;
        } else {
          var score = scores[j][i];
          sum += score;
        }
      }

      if (count == 0) {
        answer.append(calculateGrade(0.0));
      } else {
        answer.append(calculateGrade((double) sum / count));
      }
    }

    return answer.toString();
  }

  private boolean isMaxOrMin(int[][] arr, int index) {

    var targetNum = arr[index][index];

    var isMin = true;
    var isMax = true;

    for (int i = 0; i < arr.length; i++) {
      if (i != index) {
        if (isMax && targetNum <= arr[i][index]) {
          isMax = false;
        }
        if (isMin && targetNum >= arr[i][index]) {
          isMin = false;
        }
      }
    }

    return isMin || isMax;
  }

  private char calculateGrade(Double score) {
    if (score >= 90)
      return 'A';
    if (score >= 80)
      return 'B';
    if (score >= 70)
      return 'C';
    if (score >= 50)
      return 'D';

    return 'F';
  }
}
