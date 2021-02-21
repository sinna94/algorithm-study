package study.programmers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.greedy.gymSuit
import java.util.stream.Stream

class GreedyTest {
  companion object {
    @JvmStatic
    fun gymSuitArgs() = Stream.of(
      Arguments.of(5, intArrayOf(2, 4), intArrayOf(1, 3, 5), 5),
      Arguments.of(5, intArrayOf(2, 4), intArrayOf(3), 4),
      Arguments.of(3, intArrayOf(3), intArrayOf(1), 2),
      Arguments.of(4, intArrayOf(1,2,3), intArrayOf(2), 2),
      Arguments.of(5, intArrayOf(1,4,5), intArrayOf(3, 4), 3),
    )
  }

  @ParameterizedTest
  @MethodSource("gymSuitArgs")
  fun testGymSuit(n: Int, lost: IntArray, reserve: IntArray, result: Int){
    Assertions.assertEquals(result,gymSuit(n, lost, reserve))
  }
}
