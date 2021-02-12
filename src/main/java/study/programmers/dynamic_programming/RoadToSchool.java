/*
 * 2021-02-12
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */

package study.programmers.dynamic_programming;

public class RoadToSchool {
  public int solution(int m, int n, int[][] puddles) {

    int[][] road = new int[m][n];

    // 웅덩이 초기화
    for (int[] puddle : puddles) {
      road[puddle[0] - 1][puddle[1] - 1] = -1;
    }
    return search(m, n, 0, 0, road);
  }

  public int search(int m, int n, int x, int y, int[][] road) {
    if (x == m - 1 && y == n - 1) {
      return 1;
    }
    if (road[x][y] == -1) {
      return 0;
    }

    if (road[x][y] >= 1) {
      return road[x][y];
    }

    int xResult = 0;
    int yResult = 0;

    if (x + 1 < m) {
      xResult = search(m, n, x + 1, y, road);
    }

    if (y + 1 < n) {
      yResult = search(m, n, x, y + 1, road);
    }

    road[x][y] = (xResult + yResult) % 1000000007;

    return road[x][y];
  }
}
