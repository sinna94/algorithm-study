package study.programmers.greedy;

import java.util.*;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42884?language=java
 * 2021-04-05
 */

public class EnforcementCamera {
  public int solution(int[][] routes) {
    List<Route> cameraList = new ArrayList();

    Arrays.sort(routes, Comparator.comparingInt(arr -> arr[0]));

    for (int i = 0; i < routes.length; i++) {
      int[] route = routes[i];

      Iterator<Route> iterator = cameraList.iterator();
      boolean findRoute = false;
      while (iterator.hasNext() && !findRoute) {
        Route r = iterator.next();
        if (route[0] >= r.getStart() && route[0] <= r.getEnd()) {
          if(r.getStart() < route[0]){
            r.setStart(route[0]);
          }
          if (r.getEnd() > route[1]) {
            r.setEnd(route[1]);
          }
          r.setCount(r.getCount() + 1);
          findRoute = true;
        }

      }

      if (!findRoute) {
        cameraList.add(new Route(route[0], route[1]));
      }
    }

    return cameraList.size();
  }

  private class Route {
    int start;
    int end;
    int count;

    Route(int start, int end) {
      this.start = start;
      this.end = end;
      this.count = 1;
    }

    public int getStart() {
      return start;
    }

    public void setStart(int start) {
      this.start = start;
    }

    public int getEnd() {
      return end;
    }

    public void setEnd(int end) {
      this.end = end;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }
  }
}
