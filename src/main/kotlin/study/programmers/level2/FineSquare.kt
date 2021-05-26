package study.programmers.level2

/*
 * 2021-05-26
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 */

fun fineSquare(w: Int, h: Int): Long {
  val total = w.toLong() * h.toLong()

  return total - (w + h - gcd(w, h))
}

private fun gcd(num1: Int, num2: Int): Int {
  return if (num2 == 0) {
    num1
  } else {
    gcd(num2, num1 % num2)
  }
}
