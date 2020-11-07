package study.programmers.sort

class HIndex {
  fun solution(citations: IntArray): Int {
    var result = 0
    val sortedList = citations.sortedDescending()
    val max = citations.maxOrNull() ?: 0
    for (i in 0..max) {
      val index = sortedList.indexOfLast { it >= i } + 1
      if (index > result) {
        result = i
      }
    }
    return result
  }
}
