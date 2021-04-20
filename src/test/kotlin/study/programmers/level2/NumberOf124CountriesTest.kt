package study.programmers.level2;

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NumberOf124CountriesTest {

  @ParameterizedTest
  @CsvSource(
    value = [
      "1,1",
      "2,2",
      "3,4",
      "4,11",
      "5,12",
      "6,14",
      "7,21",
      "8,22",
      "9,24",
      "10,41",
      "11,42",
      "12,44",
      "13,111",
      "14,112",
      "15,114",
      "16,121",
    ]
  )
  fun testSolution(n: Int, result: String) {
    assertEquals(result, NumberOf124Countries().solution(n))
  }
}
