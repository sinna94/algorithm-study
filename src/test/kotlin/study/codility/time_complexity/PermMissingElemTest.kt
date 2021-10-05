package study.codility.time_complexity

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PermMissingElemTest {
    companion object {
        @JvmStatic
        fun permMissingElemArgs() = Stream.of(
            Arguments.of(intArrayOf(2, 3, 1, 5), 4),
            Arguments.of(intArrayOf(2, 3, 1, 4), 5)
        )
    }

    @ParameterizedTest
    @MethodSource("permMissingElemArgs")
    fun testPermMissingElem(A: IntArray, expected: Int) {
        Assertions.assertEquals(expected, permMissingElem(A))
    }
}
