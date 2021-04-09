package study.programmers.binary_search

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 * 2021-04-07
 */

// Int -> Long 으로 바꾸고 통과
fun immigration(n: Int, times: IntArray): Long {
  var start = 1L
  var end = (times.max() ?: 1).toLong() * n
  var mid: Long
  var answer = Long.MAX_VALUE

  while (start <= end) {
    mid = (start + end) / 2
    var finish = 0L
    times.forEach {
      finish += mid / it.toLong()
    }

    if (finish < n) {
      // 시간이 모자람
      start = mid + 1
    } else {
      // 시간이 남거나 딱 맞음
      if (mid < answer) {
        answer = mid
      }
      end = mid - 1L
    }
  }

  return answer
}
