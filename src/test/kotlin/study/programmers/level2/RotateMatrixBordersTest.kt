package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RotateMatrixBordersTest {
  companion object {
    @JvmStatic
    fun args(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(
          6,
          6,
          arrayOf(
            intArrayOf(2, 2, 5, 4),
            intArrayOf(3, 3, 6, 6),
            intArrayOf(5, 1, 6, 3),
          ),
          intArrayOf(8, 10, 25),
        ),
        Arguments.of(
          3,
          3,
          arrayOf(
            intArrayOf(1, 1, 2, 2),
            intArrayOf(1, 2, 2, 3),
            intArrayOf(2, 1, 3, 2),
            intArrayOf(2, 2, 3, 3),
          ),
          intArrayOf(1, 1, 5, 3),
        ),
        Arguments.of(
          100,
          97,
          arrayOf(
            intArrayOf(1, 1, 100, 97),
          ),
          intArrayOf(1),
        ),
      )
    }
  }


  @ParameterizedTest
  @MethodSource("args")
  fun test(rows: Int, columns: Int, queries: Array<IntArray>, result: IntArray) {
    assertArrayEquals(result, RotateMatrixBorders().solution(rows, columns, queries))
  }
}
