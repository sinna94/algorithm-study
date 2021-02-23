package study.codility.time_complexity

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class FrogJmpTest {
  companion object {
    @JvmStatic
    fun frogJmpArgs() = Stream.of(
      Arguments.of(10, 85, 30, 3)
    )
  }

  @ParameterizedTest
  @MethodSource("frogJmpArgs")
  fun testBinaryGapArgs(X: Int, Y: Int, D: Int, expected: Int) {
    Assertions.assertEquals(expected, frogJmp(X, Y, D))
  }
}
