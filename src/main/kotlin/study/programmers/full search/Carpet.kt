/*
 * 2020-09-02
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */

class Carpet {
  fun solution(brown: Int, yellow: Int): IntArray {
    val answer = intArrayOf()

    for (i in 1..yellow) {
      for (j in 1..yellow) {
        if (i >= j && i * j == yellow && (i + 2) * (j + 2) - yellow == brown) {
          return intArrayOf(i + 2, j + 2)
        }
      }
    }

    return answer
  }
}
