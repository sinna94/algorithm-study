/*
 * 2020-07-30
 * https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 */
class KtStockPrice {
  fun solution(prices: IntArray): IntArray {
    return prices.mapIndexed { index, i ->
      var time = prices.count() - 1 - index
      for (j in index + 1 until prices.count()) {
        if (i > prices[j]) {
          time = j - index
          break
        }
      }
      time
    }.toIntArray()
  }
}
