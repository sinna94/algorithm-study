package study.programmers.level1;

import java.util.Arrays;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * 2021-09-25
 */

public class FailureRate {

  private static class Stage implements Comparable<Stage> {
    private final int num;
    private int userCount;
    private int failureUserCount;

    public Stage(int num) {
      this.num = num;
      userCount = 0;
      failureUserCount = 0;
    }

    public void increaseUserCount() {
      userCount++;
    }

    public void increaseFailureUserCount() {
      failureUserCount++;
    }

    public int getNum() {
      return num;
    }

    private double calFailureRate() {
      if (userCount == 0) {
        return 0.0;
      }

      return (double) failureUserCount / userCount;
    }

    @Override
    public int compareTo(Stage other) {

      double failureRate = calFailureRate();
      double otherFailureRate = other.calFailureRate();

      if (failureRate == otherFailureRate) {
        return num - other.num;
      }

      return Double.compare(otherFailureRate, failureRate);
    }
  }

  public int[] solution(int N, int[] stages) {

    Stage[] stagesArr = new Stage[N];
    for (int i = 0; i < N; i++) {
      stagesArr[i] = new Stage(i + 1);
    }

    for (int stage : stages) {
      for (int i = 0; i < stage; i++) {
        if (i < N) {
          stagesArr[i].increaseUserCount();
        }
      }
      if (stage <= N) {
        stagesArr[stage - 1].increaseFailureUserCount();
      }
    }

    return Arrays.stream(stagesArr).sorted().mapToInt(Stage::getNum).toArray();
  }
}
