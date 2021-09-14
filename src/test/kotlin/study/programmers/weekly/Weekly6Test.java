package study.programmers.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Weekly6Test {
  static Stream<Arguments> weekly6Args() {
    return Stream.of(
      Arguments.of(
        new int[]{50, 82, 75, 120},
        new String[]{"NLWL", "WNLL", "LWNW", "WWLN"},
        new int[]{3, 4, 1, 2}
      ),
      Arguments.of(
        new int[]{145, 92, 86},
        new String[]{"NLW", "WNL", "LWN"},
        new int[]{2, 3, 1}
      ),
      Arguments.of(
        new int[]{60, 70, 60},
        new String[]{"NNN", "NNN", "NNN"},
        new int[]{2, 1, 3}
      )
    );
  }


  @ParameterizedTest
  @MethodSource("weekly6Args")
  void solution(int[] weights, String[] head2head, int[] result) {
    assertArrayEquals(result, new Weekly6().solution(weights, head2head));
  }
}
