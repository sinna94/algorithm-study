package study.programmers.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Weekly3Test {
  static Stream<Arguments> weekly3Args() {
    return Stream.of(
      Arguments.of(new int[][]{
          new int[]{1, 1, 0, 0, 1, 0},
          new int[]{0, 0, 1, 0, 1, 0},
          new int[]{0, 1, 1, 0, 0, 1},
          new int[]{1, 1, 0, 1, 1, 1},
          new int[]{1, 0, 0, 0, 1, 0},
          new int[]{0, 1, 1, 1, 0, 0}
        },
        new int[][]{
          new int[]{1, 0, 0, 1, 1, 0},
          new int[]{1, 0, 1, 0, 1, 0},
          new int[]{0, 1, 1, 0, 1, 1},
          new int[]{0, 0, 1, 0, 0, 0},
          new int[]{1, 1, 0, 1, 1, 0},
          new int[]{0, 1, 0, 0, 0, 0}
        },
        14),
      Arguments.of(new int[][]{
          new int[]{0, 0, 0},
          new int[]{1, 1, 0},
          new int[]{1, 1, 1},
        },
        new int[][]{
          new int[]{1, 1, 1},
          new int[]{1, 0, 0},
          new int[]{0, 0, 0},
        },
        0),
      Arguments.of(new int[][]{
          new int[]{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
          new int[]{1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
          new int[]{0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
          new int[]{1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
          new int[]{0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
          new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
          new int[]{0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
          new int[]{0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0},
          new int[]{1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0},
          new int[]{0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0},
          new int[]{0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1},
          new int[]{0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}
        },
        new int[][]{
          new int[]{1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
          new int[]{1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
          new int[]{1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
          new int[]{0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
          new int[]{1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0},
          new int[]{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
          new int[]{1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
          new int[]{1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},
          new int[]{0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1},
          new int[]{1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1},
          new int[]{1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1},
          new int[]{1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}
        },
        54)
    );
  }


  @ParameterizedTest
  @MethodSource("weekly3Args")
  void solution(int[][] game_board, int[][] table, int result) {
    assertEquals(result, new Weekly3().solution(game_board, table));
  }

}
