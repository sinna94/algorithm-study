package study.programmers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.dfs_bfs.network
import study.programmers.dfs_bfs.targetNumber
import study.programmers.dfs_bfs.travelRoute
import study.programmers.dfs_bfs.wordConversion
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

    @JvmStatic
    fun wordConversionArgs(): Stream<Arguments> {
      return Stream.of(
        Arguments.of("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"), 4),
        Arguments.of("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log"), 0)
      )
    }

    @JvmStatic
    fun travelRouteArgs(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(
          arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND")),
          arrayOf("ICN", "JFK", "HND", "IAD")
        ),
        Arguments.of(
          arrayOf(
            arrayOf("ICN", "SFO"),
            arrayOf("ICN", "ATL"),
            arrayOf("SFO", "ATL"),
            arrayOf("ATL", "ICN"),
            arrayOf("ATL", "SFO")
          ),
          arrayOf("ICN", "ATL", "ICN", "SFO", "ATL", "SFO")
        ),
        Arguments.of(
          arrayOf(arrayOf("ICN", "JFK"), arrayOf("ICN", "JFK"), arrayOf("HND", "ICN"), arrayOf("JFK", "HND")),
          arrayOf("ICN", "JFK", "HND", "ICN", "JFK")
        ),
        Arguments.of(
          arrayOf(arrayOf("ICN", "A"), arrayOf("ICN", "B"), arrayOf("B", "ICN")),
          arrayOf("ICN", "B", "ICN", "A")
        ),
        Arguments.of(
          arrayOf(arrayOf("ICN", "A"), arrayOf("ICN", "A"), arrayOf("A", "ICN")),
          arrayOf("ICN", "A", "ICN", "A")
        ),
        Arguments.of(
          arrayOf(arrayOf("ICN", "A"), arrayOf("A", "C"), arrayOf("A", "D"), arrayOf("D", "B"), arrayOf("B", "A")),
          arrayOf("ICN", "A", "D", "B", "A", "C")
        ),
        Arguments.of(
          arrayOf(
            arrayOf("ICN", "BOO"),
            arrayOf("ICN", "COO"),
            arrayOf("COO", "DOO"),
            arrayOf("DOO", "COO"),
            arrayOf("BOO", "DOO"),
            arrayOf("DOO", "BOO"),
            arrayOf("BOO", "ICN"),
            arrayOf("COO", "BOO")
          ),
          arrayOf("ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO")
        ),
      )
    }
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

  @ParameterizedTest
  @MethodSource("wordConversionArgs")
  fun testWordConversion(begin: String, target: String, words: Array<String>, answer: Int) {
    assertEquals(answer, wordConversion(begin, target, words))
  }

  @ParameterizedTest
  @MethodSource("travelRouteArgs")
  fun testTravelRoute(ticket: Array<Array<String>>, answer: Array<String>) {
    val result = travelRoute(ticket)
    println(result.joinToString())
    assertArrayEquals(answer, result)
  }
}
