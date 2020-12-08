package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.dfs_bfs.targetNumber
import java.util.stream.Stream

class DfsBfsTest {
  companion object {
    @JvmStatic
    fun targetNumberArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(intArrayOf(1, 1, 1, 1, 1), 3, 5),
      Arguments.of(intArrayOf(1, 2, 1, 1, 1), 4, 4)
    )
  }

  @ParameterizedTest
  @MethodSource("targetNumberArgs")
  fun testTargetNumber(numbers: IntArray, target: Int, answer: Int) {
    assertEquals(answer, targetNumber(numbers, target))
  }
}
