package study.programmers.level1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CreatePrimeNumberTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(intArrayOf(1, 2, 3, 4), 1),
                Arguments.of(intArrayOf(1, 2, 7, 6, 4), 4),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(nums: IntArray, result: Int) {
        Assertions.assertEquals(result, CreatePrimeNumber().solution(nums))
    }
}
