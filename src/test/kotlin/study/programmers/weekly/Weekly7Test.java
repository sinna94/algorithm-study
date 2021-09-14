package study.programmers.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Weekly7Test {
  static Stream<Arguments> weekly7Args() {
    return Stream.of(
      Arguments.of(
        new int[]{1, 3, 2},
        new int[]{1, 2, 3},
        new int[]{0, 1, 1}
      ), Arguments.of(
        new int[]{1, 4, 2, 3},
        new int[]{2, 1, 3, 4},
        new int[]{2, 2, 1, 3}
      ), Arguments.of(
        new int[]{3, 2, 1},
        new int[]{2, 1, 3},
        new int[]{1, 1, 2}
      ), Arguments.of(
        new int[]{3, 2, 1},
        new int[]{1, 3, 2},
        new int[]{2, 2, 2}
      ), Arguments.of(
        new int[]{1, 4, 2, 3},
        new int[]{2, 1, 4, 3},
        new int[]{2, 2, 0, 2}
      )
    );
  }


  @ParameterizedTest
  @MethodSource("weekly7Args")
  void solution(int[] enter, int[] leave, int[] result) {
    assertArrayEquals(result, new Weekly7().solution(enter, leave));
  }
}
