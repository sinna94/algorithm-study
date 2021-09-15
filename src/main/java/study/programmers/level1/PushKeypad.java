package study.programmers.level1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
 *  https://programmers.co.kr/learn/courses/30/lessons/67256
 *  2021-09-15
 */
public class PushKeypad {
  public String solution(int[] numbers, String hand) {
    AtomicInteger lastLeft = new AtomicInteger(10);
    AtomicInteger lastRight = new AtomicInteger(12);

    return Arrays.stream(numbers).mapToObj(num -> {
      if (isLeft(num)) {
        lastLeft.set(num);
        return "L";
      }
      if (isRight(num)) {
        lastRight.set(num);
        return "R";
      }

      if (num == 0) {
        num = 11;
      }

      int leftRowDistance = getRowDistance(lastLeft, num);
      int leftDistance = leftRowDistance + getColDistance(lastLeft);
      int rightRowDistance = getRowDistance(lastRight, num);
      int rightDistance = rightRowDistance + getColDistance(lastRight);

      if (leftDistance < rightDistance) {
        lastLeft.set(num);
        return "L";
      } else if (leftDistance > rightDistance) {
        lastRight.set(num);
        return "R";
      } else {
        if (hand.equals("right")) {
          lastRight.set(num);
          return "R";
        } else {
          lastLeft.set(num);
          return "L";
        }
      }
    }).collect(Collectors.joining());
  }

  private int getColDistance(AtomicInteger lastNum) {
    if (lastNum.get() <= 3) {
      return Math.abs(1 - (lastNum.get() - 1));
    }
    return Math.abs(1 - (lastNum.get() - 1) % 3);
  }

  private int getRowDistance(AtomicInteger lastNum, int num) {
    return Math.abs((num - 1) / 3 - (lastNum.get() - 1) / 3);
  }

  private boolean isLeft(int num) {
    return num == 1 || num == 4 || num == 7;
  }

  private boolean isRight(int num) {
    return num == 3 || num == 6 || num == 9;
  }
}
