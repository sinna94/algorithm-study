package study.programmers.weekly;
/*
 * 2021-08-04
 * https://programmers.co.kr/learn/courses/30/lessons/82612?language=java
 */

public class CalculateShortfall {
  public long solution(int price, int money, int count) {
    long sum = 0;

    for (int i = 1; i <= count; i++) {
      sum += i;
    }

    long result = money - sum * price;

    if (result >= 0) {
      return 0;
    }

    return Math.abs(result);
  }
}
