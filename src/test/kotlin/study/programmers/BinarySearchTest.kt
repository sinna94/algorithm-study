package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.binary_search.immigration
import study.programmers.binary_search.steppingStone
import study.programmers.dynamic_programming.IntegerTriangle
import study.programmers.dynamic_programming.RoadToSchool
import study.programmers.dynamic_programming.Thievery
import study.programmers.dynamic_programming.expressedByN
import java.util.stream.Stream

class BinarySearchTest {
  companion object {
    @JvmStatic
    fun immigrationArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(6, intArrayOf(7, 10), 28),
    )

    @JvmStatic
    fun steppingStoneArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(25, intArrayOf(2, 14, 11, 21, 17), 2, 4),
    )
  }

  @ParameterizedTest
  @MethodSource("immigrationArgs")
  fun testImmigration(n: Int, times: IntArray, answer: Long) {
    assertEquals(answer, immigration(n, times))
  }

  @ParameterizedTest
  @MethodSource("steppingStoneArgs")
  fun testSteppingStone(distance: Int, rocks: IntArray, n: Int, answer: Int) {
    assertEquals(answer, steppingStone(distance, rocks, n))
  }
}
