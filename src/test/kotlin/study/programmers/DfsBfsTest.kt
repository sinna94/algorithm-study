package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.dfs_bfs.network
import study.programmers.dfs_bfs.targetNumber
import java.util.stream.Stream

class DfsBfsTest {
  companion object {
    @JvmStatic
    fun targetNumberArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(intArrayOf(1, 1, 1, 1, 1), 3, 5),
      Arguments.of(intArrayOf(1, 2, 1, 1, 1), 4, 4)
    )

    @JvmStatic
    fun networkArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)), 2),
      Arguments.of(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1)), 1),
      Arguments.of(3, arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 1), intArrayOf(0, 1, 1)), 2),
      Arguments.of(3, arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 0, 1)), 2),
      Arguments.of(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)), 2),
      Arguments.of(2, arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)), 1),
      Arguments.of(4, arrayOf(intArrayOf(1, 0, 0, 1), intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 0), intArrayOf(1, 0, 0, 1)), 2),
      Arguments.of(4, arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 0, 1, 1), intArrayOf(0, 0, 1, 1)), 3),
      Arguments.of(4, arrayOf(intArrayOf(1, 0, 1, 1), intArrayOf(0, 1, 1, 0), intArrayOf(1, 1, 1, 0), intArrayOf(1, 0, 0, 1)), 1),
      Arguments.of(4, arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 1, 0, 0), intArrayOf(0, 0, 1, 0), intArrayOf(0, 0, 0, 1)), 4),
      Arguments.of(4, arrayOf(intArrayOf(1, 1, 0, 0), intArrayOf(1, 1, 0, 0), intArrayOf(0, 0, 1, 1), intArrayOf(0, 0, 1, 1)), 2),
      Arguments.of(
        6,
        arrayOf(
          intArrayOf(1, 0, 1, 1, 0, 0),
          intArrayOf(0, 1, 0, 0, 1, 1),
          intArrayOf(1, 0, 1, 1, 1, 1),
          intArrayOf(1, 0, 1, 1, 1, 1),
          intArrayOf(0, 1, 1, 1, 1, 1),
          intArrayOf(0, 1, 1, 1, 1, 1)
        ),
        1
      ),
      Arguments.of(
        5,
        arrayOf(
          intArrayOf(1, 0, 1, 0, 1),
          intArrayOf(0, 1, 0, 1, 0),
          intArrayOf(1, 0, 1, 0, 0),
          intArrayOf(0, 1, 0, 1, 1),
          intArrayOf(1, 0, 0, 1, 1)
        ),
        1
      ),
      Arguments.of(
        7,
        arrayOf(
          intArrayOf(1, 0, 0, 0, 1, 0, 1),
          intArrayOf(0, 1, 0, 0, 0, 1, 0),
          intArrayOf(0, 0, 1, 1, 0, 0, 0),
          intArrayOf(0, 0, 1, 1, 0, 1, 0),
          intArrayOf(1, 0, 0, 0, 1, 0, 0),
          intArrayOf(0, 1, 0, 1, 0, 1, 1),
          intArrayOf(1, 0, 0, 0, 0, 1, 1),
        ),
        1
      ),
      Arguments.of(3, arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1)), 3)
    )
  }

  @ParameterizedTest
  @MethodSource("targetNumberArgs")
  fun testTargetNumber(numbers: IntArray, target: Int, answer: Int) {
    assertEquals(answer, targetNumber(numbers, target))
  }

  @ParameterizedTest
  @MethodSource("networkArgs")
  fun testNetwork(n: Int, computers: Array<IntArray>, answer: Int) {
    assertEquals(answer, network(n, computers))
  }
}
