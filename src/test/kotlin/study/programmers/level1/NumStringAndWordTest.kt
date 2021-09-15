package study.programmers.level1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class NumStringAndWordTest {

  @ParameterizedTest
  @CsvSource(value = ["one4seveneight,1478", "23four5six7,234567", "2three45sixseven,234567", "123,123"])
  fun solution(s: String?, result: Int) {
    Assertions.assertEquals(result, NumStringAndWord().solution(s))
  }
}
