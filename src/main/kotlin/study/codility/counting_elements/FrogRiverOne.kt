package study.codility.counting_elements

/*
 * 2021-02-23
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */

fun frogRiverOne(X: Int, A: IntArray): Int {

  val leafArray = BooleanArray(X)

  var i = 0

  while (!leafArray.all { it } && i < A.count()) {
    leafArray[A[i++] - 1] = true
  }

  return if (leafArray.all { it }) {
    i - 1
  } else {
    -1
  }
}

