package study.programmers.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 * 2021-09-15
 */
public class LottoHighLow {
  public int[] solution(int[] lottos, int[] win_nums) {
    Set<Integer> winNumSet = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());
    int matchCount = (int) Arrays.stream(lottos).filter(winNumSet::contains).count();
    int zeroCount = (int) Arrays.stream(lottos).filter(value -> value == 0).count();

    return new int[]{calRank(matchCount + zeroCount), calRank(matchCount)};
  }

  private int calRank(int matchCount) {
    switch (matchCount) {
      case 6:
        return 1;
      case 5:
        return 2;
      case 4:
        return 3;
      case 3:
        return 4;
      case 2:
        return 5;
      default:
        return 6;
    }
  }
}
