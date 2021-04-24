package study.programmers.level2;

import java.util.*;

/*
 * 2021-04-24
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */
public class KakaoFriendsColoringBook {
  public int[] solution(int m, int n, int[][] picture) {
    int domainNum = 0;
    Boolean[][] visited = new Boolean[m][n];
    Queue<int[]> queue = new LinkedList<>();
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        visited[i][j] = false;
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j]) {
          continue;
        }

        if (picture[i][j] != 0) {
          domainNum = picture[i][j];
          numberOfArea += 1;
          queue.add(new int[]{i, j});
        }

        int sizeOfArea = 0;
        while (!queue.isEmpty()) {
          int[] point = queue.poll();
          int x = point[0];
          int y = point[1];
          if (visited[x][y]) {
            continue;
          }
          sizeOfArea += 1;
          visited[x][y] = true;
          if (y > 0 && picture[x][y - 1] == domainNum && !visited[x][y - 1]) {
            queue.add(new int[]{x, y - 1});
          }
          if (x > 0 && picture[x - 1][y] == domainNum && !visited[x - 1][y]) {
            queue.add(new int[]{x - 1, y});
          }
          if (x < m - 1 && picture[x + 1][y] == domainNum && !visited[x + 1][y]) {
            queue.add(new int[]{x + 1, y});
          }
          if (y < n - 1 && picture[x][y + 1] == domainNum && !visited[x][y + 1]) {
            queue.add(new int[]{x, y + 1});
          }
        }

        if (maxSizeOfOneArea < sizeOfArea) {
          maxSizeOfOneArea = sizeOfArea;
        }
      }
    }

    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }
}
