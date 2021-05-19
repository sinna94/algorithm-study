package study.programmers.level2;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/1835?language=java
 * 2021-05-19
 */

public class TakeGroupPhoto {
  private final char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
  private final boolean[] check = {false, false, false, false, false, false, false, false};

  public int solution(int n, String[] data) {
    var characterArray = new char[8];

    return dfs(n, data, 0, characterArray);
  }

  private boolean checkCondition(int n, String[] data, char[] arr) {
    for (int i = 0; i < n; i++) {
      char[] chars = data[i].toCharArray();
      char src = chars[0];
      char target = chars[2];
      char option = chars[3];
      var distance = chars[4] - '0';

      var srcIndex = findIndex(arr, src);
      var targetIndex = findIndex(arr, target);

      var gap = Math.abs(srcIndex - targetIndex) - 1;
      switch (option) {
        case '>':
          if (gap <= distance) {
            return false;
          }
          break;
        case '=':
          if (gap != distance) {
            return false;
          }
          break;
        case '<':
          if (gap >= distance) {
            return false;
          }
          break;
      }
    }
    return true;
  }

  private int dfs(int n, String[] data, int index, char[] arr) {

    var sum = 0;

    if (index == characters.length) {
      if (checkCondition(n, data, arr)) {
        sum += 1;
      }
      return sum;
    }

    for (int i = 0; i < characters.length; i++) {
      if (!check[i]) {
        check[i] = true;
        arr[index] = characters[i];
        sum += dfs(n, data, index + 1, arr);
        check[i] = false;
      }
    }

    return sum;
  }


  private int findIndex(char[] array, char target) {
    int index = -1;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        index = i;
        break;
      }
    }
    return index;
  }
}
