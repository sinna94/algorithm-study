package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.greedy.*
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

    @JvmStatic
    fun makingBigNumArgs() = Stream.of(
      Arguments.of("1924", 2, "94"),
      Arguments.of("1231234", 3, "3234"),
      Arguments.of("4177252841", 4, "775841"),
      Arguments.of("1924", 3, "9"),
      Arguments.of("13", 1, "3"),
      Arguments.of("31", 1, "3"),
      Arguments.of("111", 2, "1"),
    )

    @JvmStatic
    fun lifeboatArgs() = Stream.of(
      Arguments.of(intArrayOf(70, 50, 80, 50), 100, 3),
      Arguments.of(intArrayOf(70, 80, 50), 100, 3),
      Arguments.of(intArrayOf(100), 100, 1),
      Arguments.of(intArrayOf(100, 100), 100, 2),
      Arguments.of(intArrayOf(30, 30, 30), 100, 2),
      Arguments.of(intArrayOf(60, 60), 100, 2),
      Arguments.of(intArrayOf(60, 60, 60, 60), 240, 2),
    )

    @JvmStatic
    fun connectionIslandArgs() = Stream.of(
      Arguments.of(
        4,
        arrayOf(
          intArrayOf(0, 1, 1),
          intArrayOf(0, 2, 2),
          intArrayOf(1, 2, 5),
          intArrayOf(1, 3, 1),
          intArrayOf(2, 3, 8),
        ),
        4
      ),
      Arguments.of(
        4,
        arrayOf(
          intArrayOf(0, 1, 5),
          intArrayOf(0, 2, 3),
          intArrayOf(2, 3, 3),
          intArrayOf(3, 1, 2),
          intArrayOf(3, 0, 4),
        ),
        8
      ),
      Arguments.of(
        5,
        arrayOf(
          intArrayOf(0, 1, 1),
          intArrayOf(3, 1, 1),
          intArrayOf(0, 2, 2),
          intArrayOf(0, 3, 2),
          intArrayOf(0, 4, 100),
        ),
        104
      ),
    )

    @JvmStatic
    fun enforcementCameraArgs() = Stream.of(
      Arguments.of(
        arrayOf(
          intArrayOf(-20, 15),
          intArrayOf(-14, -5),
          intArrayOf(-18, -13),
          intArrayOf(-5, -3),
        ),
        2
      ),
    )
  }

  @ParameterizedTest
  @MethodSource("gymSuitArgs")
  fun testGymSuit(n: Int, lost: IntArray, reserve: IntArray, result: Int) {
    assertEquals(result, gymSuit(n, lost, reserve))
  }

  @ParameterizedTest
  @MethodSource("joyStickArgs")
  fun testJoyStick(name: String, result: Int) {
    assertEquals(result, joyStick(name))
  }

  @ParameterizedTest
  @MethodSource("makingBigNumArgs")
  fun testMakingBigNum(number: String, k: Int, result: String) {
    assertEquals(result, solution(number, k))
  }

  @ParameterizedTest
  @MethodSource("lifeboatArgs")
  fun testLifeboat(people: IntArray, limit: Int, result: Int) {
    assertEquals(result, Lifeboat().solution(people, limit))
  }

  @ParameterizedTest
  @MethodSource("connectionIslandArgs")
  fun testConnectingIsland(n: Int, costs: Array<IntArray>, result: Int) {
    assertEquals(result, connectingIsland(n, costs))
  }

  @ParameterizedTest
  @MethodSource("enforcementCameraArgs")
  fun testEnforcementCamera(routes: Array<IntArray>, result: Int) {
    assertEquals(result, EnforcementCamera().solution(routes))
  }
}
