package study.codility.arrays

/*
 * 2021-02-23
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */

fun solution(A: IntArray, K: Int): IntArray {
  if (A.count() == 0) {
    return A
  }

  val list = A.toMutableList()

  for (i in 0 until K) {
    list.add(0, list.removeAt(list.count() - 1))
  }
  return list.toIntArray()
}
