package study.programmers.dynamic_programming

/*
 * 2021-02-07
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 */

fun expressedByN(N: Int, number: Int): Int {

  val resultList = mutableListOf<MutableSet<Int>>()

  var linearNum = 0

  for (i in 0..8) {

    linearNum = linearNum * 10 + N

    val set = mutableSetOf(linearNum)

    for (j in 0 until i) {
      resultList[j].forEach { num ->
        resultList[i - j - 1].forEach { num2 ->
          cal(num, num2, set)
        }
      }
    }
    if (set.contains(number)) {
      return i + 1
    }

    resultList.add(i, set)
  }
  return -1
}

fun cal(num1: Int, num2: Int, set: MutableSet<Int>) {
  set.add(num1 + num2)
  set.add(num1 - num2)
  set.add(num1 * num2)

  if (num2 != 0) {
    set.add(num1 / num2)
  }
  if (num1 != 0) {
    set.add(num2 / num1)
  }
}
