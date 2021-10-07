package study.programmers.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Weekly9Test {
    static Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(
                9,
                new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}},
                3
            ), Arguments.of(
                4,
                new int[][]{{1, 2}, {2, 3}, {3, 4}},
                0
            ), Arguments.of(
                7,
                new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}},
                1
            ), Arguments.of(
                8,
                new int[][]{{1, 2}, {1, 3}, {1, 4}, {4, 5}, {5, 6}, {6, 7}, {6, 8}},
                0
            )
        );
    }


    @ParameterizedTest
    @MethodSource("args")
    void solution(int n, int[][] wires, int result) {
        assertEquals(result, new Weekly9().solution(n, wires));

    }
}
