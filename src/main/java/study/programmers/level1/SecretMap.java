package study.programmers.level1;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 * 2021-09-23
 */
public class SecretMap {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    AtomicInteger index = new AtomicInteger();

    return Arrays.stream(arr1).mapToObj(num -> {
        int orResult = num | arr2[index.getAndIncrement()];
        String resultString = Integer.toBinaryString(orResult)
          .replaceAll("1", "#")
          .replaceAll("0", " ");
        return String.format("%" + n + "s", resultString);
      }
    ).toArray(String[]::new);
  }
}
