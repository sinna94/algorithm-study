package study.codility.iterations

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BinaryGapTest {
    companion object {
        @JvmStatic
        fun binaryGapArgs() = Stream.of(
            Arguments.of(9, 2),
            Arguments.of(529, 4),
            Arguments.of(20, 1),
            Arguments.of(15, 0),
            Arguments.of(32, 0),
            Arguments.of(1041, 5),
            Arguments.of(2147483647, 0)
        )
    }

    @ParameterizedTest
    @MethodSource("binaryGapArgs")
    fun testBinaryGap(A: Int, expected: Int) {
        Assertions.assertEquals(expected, solution(A))
    }
}
