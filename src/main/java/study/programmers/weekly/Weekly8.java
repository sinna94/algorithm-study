package study.programmers.weekly;

public class Weekly8 {
  public int solution(int[][] sizes) {

    int longSize = 0;
    int shortSize = 0;

    for (int[] size : sizes) {
      int s1 = size[0];
      int s2 = size[1];

      if (s1 > s2) {
        longSize = Math.max(s1, longSize);
        shortSize = Math.max(s2, shortSize);
      }else{
        longSize = Math.max(s2, longSize);
        shortSize = Math.max(s1, shortSize);
      }
    }

    return longSize * shortSize;
  }
}
