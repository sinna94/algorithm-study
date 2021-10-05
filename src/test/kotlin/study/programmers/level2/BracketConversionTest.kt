package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BracketConversionTest {
  companion object {
    @JvmStatic
    fun args(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(
          "(()())()", "(()())()"
        ),
        Arguments.of(
          ")(", "()"
        ),
        Arguments.of(
          "()))((()", "()(())()"
        ),
        Arguments.of(
          ")()()()(", "(((())))"
        ),
      )
    }
  }


  @ParameterizedTest
  @MethodSource("args")
  fun test(p: String, result: String) {
    assertEquals(result, BracketConversion().solution(p))
  }
}
