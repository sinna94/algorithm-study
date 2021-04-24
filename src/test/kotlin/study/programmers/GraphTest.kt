package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.graph.farthestNode
import study.programmers.graph.ranking
import java.util.stream.Stream

class GraphTest {
  companion object {
    @JvmStatic
    fun farthestNodeArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(
        6,
        arrayOf(
          intArrayOf(3, 6),
          intArrayOf(4, 3),
          intArrayOf(3, 2),
          intArrayOf(1, 3),
          intArrayOf(1, 2),
          intArrayOf(2, 4),
          intArrayOf(5, 2),
        ),
        3
      ),
    )

    @JvmStatic
    fun rankingArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(
        5,
        arrayOf(
          intArrayOf(4, 3),
          intArrayOf(4, 2),
          intArrayOf(3, 2),
          intArrayOf(1, 2),
          intArrayOf(2, 5),
        ),
        2
      )
    )
  }

  @ParameterizedTest
  @MethodSource("farthestNodeArgs")
  fun testFarthestNode(n: Int, edge: Array<IntArray>, answer: Number) {
    assertEquals(answer, farthestNode(n, edge))
  }

  @ParameterizedTest
  @MethodSource("rankingArgs")
  fun testRanking(n: Int, results: Array<IntArray>, answer: Int) {
    assertEquals(answer, ranking(n, results))
  }
}
