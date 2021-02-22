package study.codility.counting_elements

/*
 * 2021-02-22
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */

fun solveMissingInteger(A: IntArray): Int {
  val numSet = A.toSet()

  // 코틀린 1.3 기준
  A.max()?.let {
    for (i in 1..it + 1) {
      if (!numSet.contains(i)) {
        return i
      }
    }
  }

  return 1
}

