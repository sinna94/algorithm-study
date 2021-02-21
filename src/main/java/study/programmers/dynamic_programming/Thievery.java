/*
 * 2021-02-14
 * https://programmers.co.kr/learn/courses/30/lessons/42897?language=java
 */

package study.programmers.dynamic_programming;

public class Thievery {
  public int solution(int[] money) {
    // 일자로 생각하고 점화식을 만든 후
    // 원형임을 고려하자

    // 처음 집은 포함하지 않는 경우
    int[] dp = new int[money.length];
    dp[0] = 0;
    dp[1] = money[1];

    // 처음 집을 포함하는 경우
    int[] dp2 = new int[money.length];
    dp2[0] = money[0];
    dp2[1] = Math.max(money[0], money[1]);

    for (int i = 2; i < money.length; i++) {
      dp[i] = Math.max(dp[i - 1], money[i] + dp[i - 2]);
    }

    for (int i = 2; i < money.length - 1; i++) {
      dp2[i] = Math.max(dp2[i - 1], money[i] + dp2[i - 2]);
    }

    return Math.max(getLargest(dp), getLargest(dp2));
  }

  public int getLargest(int[] arr) {
    int largest = 0;

    for (int num : arr) {
      if (num > largest) {
        largest = num;
      }
    }
    return largest;
  }
}
