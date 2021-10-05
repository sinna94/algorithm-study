package study.codility.counting_elements

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MissingIntegerTest {
    companion object {
        @JvmStatic
        fun missingIntegerArgs() = Stream.of(
            Arguments.of(intArrayOf(1, 3, 6, 4, 1, 2), 5),
            Arguments.of(intArrayOf(1, 2, 3), 4),
            Arguments.of(intArrayOf(-1, -3), 1),
        )
    }

    @ParameterizedTest
    @MethodSource("missingIntegerArgs")
    fun testMissingInteger(A: IntArray, expected: Int) {
        Assertions.assertEquals(expected, solveMissingInteger(A))
    }
}
