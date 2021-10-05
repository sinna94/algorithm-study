package study.programmers.level1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FailureRateTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3), intArrayOf(3, 4, 2, 1, 5)),
                Arguments.of(4, intArrayOf(4, 4, 4, 4, 4), intArrayOf(4, 1, 2, 3)),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(N: Int, stages: IntArray, result: IntArray) {
        Assertions.assertArrayEquals(result, FailureRate().solution(N, stages))
    }
}
