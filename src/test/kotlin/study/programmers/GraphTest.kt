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
import study.programmers.graph.farthestNode
import java.util.stream.Stream

class GraphTest {
  companion object {
    @JvmStatic
    fun farthestNodeArgs(): Stream<Arguments> = Stream.of(
      Arguments.of(
        6, arrayOf(
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
  }

  @ParameterizedTest
  @MethodSource("farthestNodeArgs")
  fun testFarthestNode(n: Int, edge: Array<IntArray>, answer: Number) {
    assertEquals(answer, farthestNode(n, edge))
  }
}
