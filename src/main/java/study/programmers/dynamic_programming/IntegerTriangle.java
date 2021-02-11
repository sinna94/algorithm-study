/*
 * 2021-02-12
 * https://programmers.co.kr/learn/courses/30/lessons/43105?language=java
 */

package study.programmers.dynamic_programming;

import java.util.ArrayList;
import java.util.Comparator;

public class IntegerTriangle {
  public int solution(int[][] triangle) {
    ArrayList<Integer> prevList = new ArrayList();
    ArrayList<Integer> sumList = new ArrayList();

    prevList.add(0);

    for (int[] row : triangle) {
      int i = 0;
      for (int num : row) {
        // 행의 처음 수
        if (i == 0) {
          sumList.add(prevList.get(i) + num);
        } else if (i == row.length - 1) {
          sumList.add(prevList.get(i - 1) + num);
        } else {
          int num1 = prevList.get(i - 1);
          int num2 = prevList.get(i);
          sumList.add(Math.max(num1, num2) + num);
        }
        i++;
      }
      prevList.clear();
      prevList.addAll(sumList);
      sumList.clear();
    }

    prevList.sort(Comparator.naturalOrder());

    return prevList.get(prevList.size() - 1);
  }
}
