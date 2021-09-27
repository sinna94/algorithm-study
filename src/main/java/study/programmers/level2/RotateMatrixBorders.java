package study.programmers.level2;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 * 2021-09-27
 */

import java.util.Arrays;

public class RotateMatrixBorders {
  public int[] solution(int rows, int columns, int[][] queries) {

    int[][] arr = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        arr[i][j] = i * columns + j + 1;
      }
    }

    return Arrays.stream(queries).mapToInt(pointArr -> rotate(rows, columns, arr, pointArr)).toArray();
  }

  private int rotate(int rows, int columns, int[][] arr, int[] pointArr) {
    int x1 = pointArr[1] - 1;
    int y1 = pointArr[0] - 1;
    int x2 = pointArr[3] - 1;
    int y2 = pointArr[2] - 1;

    int min = rows * columns + 1;
    int topTemp = 0;
    int bottomTemp = 0;

    for (int i = y1; i <= y2; i++) {
      if (i == y1) {
        // 상단
        // 가장 오른쪽 값
        topTemp = arr[i][x2];
        bottomTemp = arr[y2][x2];

        min = Math.min(min, topTemp);
        min = Math.min(min, bottomTemp);

        for (int j = x2; j > x1; j--) {
          int rightCell = arr[i][j - 1];
          min = Math.min(min, rightCell);
          arr[i][j] = rightCell;
        }
      }

      if (i == y2) {
        // 하단
        for (int j = x1; j < x2 - 1; j++) {
          int leftCell = arr[i][j + 1];
          min = Math.min(min, leftCell);
          arr[i][j] = leftCell;
        }
      }

      if (i < y2) {
        // 왼쪽
        int upCell = arr[i + 1][x1];
        min = Math.min(min, upCell);
        arr[i][x1] = upCell;
        // 오른쪽
        int bottomCell = arr[y2 - (i - y1) - 1][x2];
        min = Math.min(min, bottomCell);
        arr[y2 - (i - y1)][x2] = bottomCell;
      }
    }
    arr[y1 + 1][x2] = topTemp;
    arr[y2][x2 - 1] = bottomTemp;
    return min;
  }
}
