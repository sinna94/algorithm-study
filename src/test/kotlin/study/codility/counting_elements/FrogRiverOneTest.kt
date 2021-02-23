package study.codility.counting_elements

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FrogRiverOneTest {
  companion object {
    @JvmStatic
    fun fogRiverOneArgs() = Stream.of(
      Arguments.of(5, intArrayOf(1, 3, 1, 4, 2, 3, 5, 4), 6),
      Arguments.of(2, intArrayOf(1, 1), -1),
      Arguments.of(2, intArrayOf(1, 2), 1),
    )
  }

  @ParameterizedTest
  @MethodSource("fogRiverOneArgs")
  fun testFogRiverOne(X: Int, A: IntArray, expected: Int) {
    Assertions.assertEquals(expected, frogRiverOne(X, A))
  }
}

