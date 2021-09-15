package study.programmers.level1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PushKeypadTest {
  companion object {
    @JvmStatic
    fun pushKeypadArgs(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right", "LRLLLRLLRRL"),
        Arguments.of(intArrayOf(7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2), "left", "LRLLRRLLLRR"),
        Arguments.of(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), "right", "LLRLLRLLRL"),
      )
    }
  }


  @ParameterizedTest
  @MethodSource("pushKeypadArgs")
  fun testPushKeypad(numbers: IntArray, hand: String, result: String) {
    assertEquals(result, PushKeypad().solution(numbers, hand))
  }
}
