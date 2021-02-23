package study.codility.time_complexity

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TapeEquilibriumTest {
  companion object {
    @JvmStatic
    fun tapeEquilibriumArgs() = Stream.of(
      Arguments.of(intArrayOf(3, 1, 2, 4, 3), 1),
      Arguments.of(intArrayOf(2, 1), 1),
    )
  }

  @ParameterizedTest
  @MethodSource("tapeEquilibriumArgs")
  fun testTapeEquilibrium(A: IntArray, expected: Int) {
    Assertions.assertEquals(expected, tapeEquilibrium(A))
  }
}
