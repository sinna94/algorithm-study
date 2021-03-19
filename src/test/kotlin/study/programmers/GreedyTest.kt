package study.programmers

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.greedy.gymSuit
import study.programmers.greedy.joyStick
import java.util.stream.Stream

class GreedyTest {
  companion object {
    @JvmStatic
    fun gymSuitArgs() = Stream.of(
      Arguments.of(5, intArrayOf(2, 4), intArrayOf(1, 3, 5), 5),
      Arguments.of(5, intArrayOf(2, 4), intArrayOf(3), 4),
      Arguments.of(3, intArrayOf(3), intArrayOf(1), 2),
      Arguments.of(4, intArrayOf(1, 2, 3), intArrayOf(2), 2),
      Arguments.of(5, intArrayOf(1, 4, 5), intArrayOf(3, 4), 3)
    )

    @JvmStatic
    fun joyStickArgs() = Stream.of(
      Arguments.of("JEROEN", 56),
      Arguments.of("JAN", 23),
      Arguments.of("ABBA", 4),
      Arguments.of("ABABA", 5),
      Arguments.of("AABAA", 3),
      Arguments.of("BABAAB", 7),
      Arguments.of("A", 0),
      Arguments.of("B", 1),
      Arguments.of("BBBAAAB", 10),
      Arguments.of("ABABAAAAABA", 11),
      Arguments.of("AAA", 0),
      Arguments.of("ZZZ", 5),
    )
  }

  @ParameterizedTest
  @MethodSource("gymSuitArgs")
  fun testGymSuit(n: Int, lost: IntArray, reserve: IntArray, result: Int) {
    Assertions.assertEquals(result, gymSuit(n, lost, reserve))
  }

  @ParameterizedTest
  @MethodSource("joyStickArgs")
  fun testJoyStick(name: String, result: Int) {
    Assertions.assertEquals(result, joyStick(name))
  }
}
