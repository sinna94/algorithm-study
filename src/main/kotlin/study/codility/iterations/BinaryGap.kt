package study.codility.iterations

/*
 * 2021-02-22
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */

fun solution(N: Int): Int {
  val binaryString = N.toString(2)
//  var num = N
//  do {
//    binaryString += num % 2
//    num /= 2
//  } while (num != 1)
//  binaryString += "1"
//  binaryString = binaryString.reversed()

  val zeroList = binaryString.split("1").toMutableList()

  if (binaryString.last() != '1') {
    // kotlin 1.3
    zeroList.removeAt(zeroList.count() - 1)
  }

  // kotlin 1.3
  return zeroList.map { it.count() }.max() ?: 0
}
