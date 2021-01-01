package study.programmers.heap;
/*
 * 2020-09-07
 * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
 */

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class MoreSpicy {
  public int solution(int[] scoville, int K) {
    PriorityQueue<Integer> scovilleQueue = new PriorityQueue();
    for (int i = 0; i < scoville.length; i++) {
      scovilleQueue.add(scoville[i]);
    }

    int cnt = 0;
    while (!scovilleQueue.isEmpty()) {
      if (scovilleQueue.size() >= 2) {
        int food1 = scovilleQueue.poll();
        int food2 = scovilleQueue.poll();
        int newScoville = food1 + food2 * 2;
        ++cnt;
        if (newScoville >= K) {
          AtomicBoolean allCheck = new AtomicBoolean(true);
          scovilleQueue.forEach(s -> {
            if (s < K) allCheck.set(false);
          });
          if (allCheck.get()) {
            return cnt;
          }
        }
        scovilleQueue.add(newScoville);
      } else {
        return -1;
      }
    }
    return -1;
  }
}
