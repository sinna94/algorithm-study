package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DistanceCheckTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"),
                        arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
                        arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"),
                        arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
                        arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
                    ),
                    intArrayOf(1, 0, 1, 1, 1)
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(places: Array<Array<String>>, result: IntArray) {
        assertArrayEquals(result, DistanceCheck().solution(places))
    }
}
