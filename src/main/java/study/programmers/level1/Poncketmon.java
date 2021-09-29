package study.programmers.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Poncketmon {
  public int solution(int[] nums) {
    int n = nums.length;
    return Arrays.stream(nums).boxed().collect(
      Collectors.collectingAndThen(Collectors.toSet(),
        set -> Math.min(set.size(), n / 2)
      ));
  }
}
