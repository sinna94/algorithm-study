package programmers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import programmers.heap.DiskController;
import programmers.heap.MoreSpicy;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class heapTest {
    @Test
    public void moreSpicyTest() {
        int result = new MoreSpicy().solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        assertEquals(2, result);
    }

    private static Stream<Arguments> diskControllerArgs() {
        return Stream.of(
                arguments(9, new int[][]{{0, 3}, {1, 9}, {2, 6}}),
                arguments(3, new int[][]{{0, 1}, {1, 2}, {500, 6}}),
                arguments(6, new int[][]{{0, 3}, {1, 9}, {500, 6}}),
                arguments(1, new int[][]{{0, 1}, {0, 1}, {1, 0}}),
                arguments(3, new int[][]{{0, 3}, {4, 3}, {8, 3}}),
                arguments(3, new int[][]{{0, 5}, {6, 2}, {6, 1}}),
                arguments(3, new int[][]{{0, 5}, {6, 1}, {6, 2}}),
                arguments(5, new int[][]{{0, 5}, {2, 2}, {5, 3}}),
                arguments(5, new int[][]{{0, 5}, {2, 2}, {4, 2}}),
                arguments(3, new int[][]{{0, 2}, {3, 6}, {3, 1}}),
                arguments(6, new int[][]{{0, 5}, {1, 2}, {5, 5}}),
                arguments(13, new int[][]{{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}}),
                arguments(13, new int[][]{{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}})
        );
    }

    @ParameterizedTest
    @MethodSource("diskControllerArgs")
    public void diskControllerTest(int result, int[][] jobs) {
        assertEquals(result, new DiskController().solution(jobs));
    }
}
