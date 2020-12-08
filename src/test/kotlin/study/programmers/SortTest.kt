package study.programmers

import KtStockPrice
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.sort.HIndex
import study.programmers.sort.KthNumber
import study.programmers.sort.LargestNumber
import study.programmers.stack_queue.StockPrice
import java.util.stream.Stream

class SortTest {
  companion object {
    @JvmStatic
    fun hIndexArgs() = Stream.of(
      Arguments.of(3, intArrayOf(3, 0, 6, 1, 5)),
      Arguments.of(4, intArrayOf(5, 5, 5, 5)),
    )
  }

  @ParameterizedTest
  @MethodSource("hIndexArgs")
  fun testHIndexTest(expected: Int, citations: IntArray) {
    val result = HIndex().solution(
      citations
    )
    assertEquals(expected, result)
  }

  @Test
  fun testKthNumberTest() {
    val result = KthNumber().solution(
      intArrayOf(1, 5, 2, 6, 3, 7, 4),
      arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    )
    val expected = intArrayOf(5, 6, 3)
    assertEquals(expected.count(), result.count())
    result.forEachIndexed { index, r ->
      assertEquals(expected[index], r)
    }
  }

  @Test
  fun testKtStockPriceTest() {
    val result = KtStockPrice().solution(
      intArrayOf(1, 2, 3, 2, 3)
    )
    val expected = intArrayOf(4, 3, 1, 1, 0)
    assertEquals(expected.count(), result.count())
    result.forEachIndexed { index, r ->
      assertEquals(expected[index], r)
    }
  }

  @Test
  fun testStockPriceTest() {
    val result = StockPrice().solution(
      intArrayOf(1, 2, 3, 2, 3)
    )
    val expected = intArrayOf(4, 3, 1, 1, 0)
    assertEquals(expected.count(), result.count())
    result.forEachIndexed { index, r ->
      assertEquals(expected[index], r)
    }
  }

  @Test
  fun testLargestNumberTest() {
    val result = LargestNumber().solution(
      intArrayOf(3, 3, 753, 95, 473, 34, 409, 5, 9, 0, 0)
    )
    val expected = "9957535473409343300"
    assertEquals(expected, result)
  }
}
