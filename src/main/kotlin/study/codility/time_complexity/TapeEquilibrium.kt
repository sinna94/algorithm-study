package study.codility.time_complexity

import kotlin.math.abs

/*
 * 2021-02-23
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
fun tapeEquilibrium(A: IntArray): Int {

  var sumList = mutableListOf<Int>()
  var firstPartSum = 0
  var secondPartSum = A.sum()

  for (i in 0 until A.count() - 1) {
    firstPartSum += A[i]
    secondPartSum -= A[i]
    sumList.add(abs(firstPartSum - secondPartSum))
  }

  return sumList.min() ?: 0
}
