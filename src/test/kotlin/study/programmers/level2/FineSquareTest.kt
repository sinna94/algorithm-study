package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class FineSquareTest {

  @CsvSource(
    value = [
      "8,12,80"
    ]
  )
  @ParameterizedTest
  fun fineSquare(w: Int, h: Int, result: Long) {
    assertEquals(result, fineSquare(w, h))
  }
}
