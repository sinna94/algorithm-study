package study.programmers.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Weekly5Test {

  @ParameterizedTest
  @CsvSource(value = {
    "AAAAE,6",
    "AAAE,10",
    "I,1563",
    "EIO,1189"
  })
  void solution(String word, int result) {
    assertEquals(result, new Weekly5().solution(word));
  }
}
