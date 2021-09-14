package study.programmers.weekly;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86048
 * 2021-09-14
 */

public class Weekly7 {
  public int[] solution(int[] enter, int[] leave) {
    /*
     뒤에 들어온 사람보다 늦게 나가면 무조건 만난다.
     and
     1, 2, 3 들어오고 3, 1, 2 로 나갈 때
     2 가 1 보다 늦게 들어오고 늦게 나가지만
     순서상 3이 나갈 때 까지 나갈 수 없기 떄문에 만날 수 밖에 없다.
     따라서 나보다 늦게 들어온 사람이 나보다 먼저 나갈 때 그 사이에 들어온 사람은 만난다
    */
    // 사람 번호 to index
    HashMap<Integer, Integer> leaveMap = new HashMap<>();
    // 어떤 사람과 만났는지 확인하는 2차원 배열
    int[][] meetArr = new int[enter.length][enter.length];

    for (int i = 0; i < leave.length; i++) {
      leaveMap.put(leave[i], i);
    }

    for (int i = 0; i < enter.length; i++) {
      Integer leaveIndex = leaveMap.get(enter[i]);
      for (int j = i + 1; j < enter.length; j++) {
        // 나보다 뒤에 들어온 사람
        int lateEnterPerson = enter[j];
        Integer lateEnterPersonLeaveIndex = leaveMap.get(lateEnterPerson);
        // 먼저 나갈 때
        if (leaveIndex > lateEnterPersonLeaveIndex) {
          System.out.println(enter[i] + " : " + lateEnterPerson);
          meetArr[enter[i] - 1][lateEnterPerson - 1] = 1;
          meetArr[lateEnterPerson - 1][enter[i] - 1] = 1;

          for (int k = i + 1; k < j; k++) {
            System.out.println("--------");
            System.out.println(enter[k] + " : " + enter[i]);
            meetArr[enter[k] - 1][enter[i] - 1] = 1;
            meetArr[enter[i] - 1][enter[k] - 1] = 1;
            System.out.println("---end---");
          }
        }
      }
    }

    return Arrays
      .stream(meetArr)
      .mapToInt(personArray -> Arrays.stream(personArray).sum())
      .toArray();
  }
}
