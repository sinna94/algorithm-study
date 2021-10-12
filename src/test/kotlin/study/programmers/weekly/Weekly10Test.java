package study.programmers.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Weekly10Test {
    static Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(
                new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}},
                new String[]{"....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"}
            ), Arguments.of(
                new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}},
                new String[]{"*.*"}
            ), Arguments.of(
                new int[][]{{1, -1, 0}, {2, -1, 0}},
                new String[]{"*"}
            ), Arguments.of(
                new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}},
                new String[]{"*"}
            ), Arguments.of(
                new int[][]{{1, 1, 0}, {0, 1, 0}},
                new String[]{"*"}
            )
        );
    }


    @ParameterizedTest
    @MethodSource("args")
    void solution(int[][] line, String[] result) {
        assertArrayEquals(result, new Weekly10().solution(line));
    }
}
