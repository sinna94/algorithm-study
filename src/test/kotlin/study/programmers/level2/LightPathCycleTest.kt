package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LightPathCycleTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf("SL", "LR"),
                    intArrayOf(16)
                ),
                Arguments.of(
                    arrayOf("S"),
                    intArrayOf(1, 1, 1, 1)
                ),
                Arguments.of(
                    arrayOf("R", "R"),
                    intArrayOf(4, 4)
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(grid: Array<String>, result: IntArray) {
        assertArrayEquals(result, LightPathCycle().solution(grid))
    }
}
