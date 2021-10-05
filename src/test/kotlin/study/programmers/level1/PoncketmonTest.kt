package study.programmers.level1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PoncketmonTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(3, 1, 2, 3), 2),
                Arguments.of(
                    intArrayOf(3, 3, 3, 2, 2, 4), 3,
                ),
                Arguments.of(intArrayOf(3, 3, 3, 2, 2, 2), 2),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(nums: IntArray, result: Int) {
        Assertions.assertEquals(result, Poncketmon().solution(nums))
    }
}
