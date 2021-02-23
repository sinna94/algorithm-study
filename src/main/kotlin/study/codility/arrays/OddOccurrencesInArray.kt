package study.codility.arrays

/*
 * 2021-02-23
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */

fun solution(A: IntArray): Int {
  return A
    .groupBy { it }
    .filter { it.value.count() == 1 }
    .keys.elementAt(0)
}
