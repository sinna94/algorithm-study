package study.programmers.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Weekly2Test {
  static Stream<Arguments> weekly2Args() {
    return Stream.of(
      Arguments.of(
        new int[][]{
          new int[]{100, 90, 98, 88, 65},
          new int[]{50, 45, 99, 85, 77},
          new int[]{47, 88, 95, 80, 67},
          new int[]{61, 57, 100, 80, 65},
          new int[]{24, 90, 94, 75, 65},
        }, "FBABD"
      ),
      Arguments.of(
        new int[][]{
          new int[]{50, 90},
          new int[]{50, 87},
        }, "DA"
      ),
      Arguments.of(
        new int[][]{
          new int[]{70, 49, 90},
          new int[]{68, 50, 38},
          new int[]{73, 31, 100},
        }, "CFD"
      )
    );
  }


  @ParameterizedTest
  @MethodSource("weekly2Args")
  void solution(int[][] scores, String result) {
    assertEquals(result, new Weekly2().solution(scores));
  }
}
