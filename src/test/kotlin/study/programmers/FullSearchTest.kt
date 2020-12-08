package study.programmers

import Carpet
import PracticeTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.`full search`.FindPrimeNumber
import java.util.stream.Stream

class FullSearchTest {
  companion object {
    @JvmStatic
    fun carpetArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(10, 2, intArrayOf(4, 3)),
      Arguments.of(8, 1, intArrayOf(3, 3)),
      Arguments.of(24, 24, intArrayOf(8, 6)),
    )

    @JvmStatic
    fun numbersArgs(): Stream<Arguments> = Stream.of(
      Arguments.of("011", 2),
      Arguments.of("17", 3),
      Arguments.of("2", 1)
    )
  }

  @ParameterizedTest
  @MethodSource("carpetArgs")
  fun testCarpet(brown: Int, yellow: Int, expected: IntArray) {
    val result = Carpet().solution(brown, yellow)
    assertEquals(result[0], expected[0])
    assertEquals(result[1], expected[1])
  }

  @ParameterizedTest
  @MethodSource("numbersArgs")
  fun testFindPrimeNumber(numbers: String, expected: Int) {
    val result = FindPrimeNumber().solution(numbers)
    assertEquals(expected, result)
  }

  @Test
  fun testPracticeTest() {
    val result = PracticeTest().solution(
      intArrayOf(1, 3, 2, 4, 2)
    )
    val expected = intArrayOf(1, 2, 3)
    assertEquals(expected.count(), result.count())
    result.forEachIndexed { index, r ->
      assertEquals(expected[index], r)
    }
  }
}
