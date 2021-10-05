package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TakeGroupPhotoTest {
    companion object {
        @JvmStatic
        fun groupPhotoArgs() = Stream.of(
            Arguments.of(
                2, arrayOf("N~F=0", "R~T>2"), 3648
            ),
            Arguments.of(
                2, arrayOf("M~C<2", "C~M>1"), 0
            )
        )
    }

    @ParameterizedTest
    @MethodSource("groupPhotoArgs")
    fun testSolution(n: Int, data: Array<String>, result: Int) {
        assertEquals(result, TakeGroupPhoto().solution(n, data))
    }
}
