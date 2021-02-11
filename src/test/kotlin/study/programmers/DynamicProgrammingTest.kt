package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.dynamic_programming.IntegerTriangle
import study.programmers.dynamic_programming.expressedByN
import java.util.stream.Stream

class DynamicProgrammingTest {
  companion object {
    @JvmStatic
    fun expressedByNArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(5, 12, 4),
      Arguments.of(2, 11, 3),
      Arguments.of(5, 31168, -1),
      Arguments.of(1, 1121, 7),
      Arguments.of(5, 3600, 6),
    )

    @JvmStatic
    fun integerTriangleArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(arrayOf(intArrayOf(7), intArrayOf(3, 8), intArrayOf(8, 1, 0), intArrayOf(2, 7, 4, 4), intArrayOf(4, 5, 2, 6, 5)), 30)
    )
  }

  @ParameterizedTest
  @MethodSource("expressedByNArgs")
  fun testExpressedByNArgs(N: Int, number: Int, answer: Int) {
    assertEquals(answer, expressedByN(N, number))
  }

  @ParameterizedTest
  @MethodSource("integerTriangleArgs")
  fun testIntegerTriangle(triangle: Array<IntArray>, answer: Int) {
    assertEquals(answer, IntegerTriangle().solution(triangle))
  }
}
