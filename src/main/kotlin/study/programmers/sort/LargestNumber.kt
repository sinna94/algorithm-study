package study.programmers.sort

class LargestNumber {
  fun solution(numbers: IntArray): String {
    var answer = ""

    numbers.sortedWith { n1, n2 ->
      val n1s = n1.toString()
      val n2s = n2.toString()

      when {
        n1s + n2s > n2s + n1s ->
          -1
        n1s + n2s < n2s + n1s ->
          1
        else ->
          0
      }
    }.forEach {
      if (answer != "0" || it != 0) {
        answer += it
      }
    }
    return answer
  }
}
