/*
 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=kotlin
 * 2021-02-22
 */

package study.programmers.greedy

fun gymSuit(n: Int, lost: IntArray, reserve: IntArray): Int {

  val lostSet = lost.toMutableSet()
  val reserveSet = reserve.toMutableSet()

  // 여벌이 있는데 잃어버린 않은 사람들은 도난, 여벌 목록에서 제거
  reserve.filter {
    lostSet.contains(it)
  }.forEach {
    reserveSet.remove(it)
    lostSet.remove(it)
  }

  reserveSet.forEach {
    when {
      lostSet.contains(it - 1) ->
        lostSet.remove(it - 1)
      lostSet.contains(it + 1) ->
        lostSet.remove(it + 1)
    }
  }

  return n - lostSet.count()
}
