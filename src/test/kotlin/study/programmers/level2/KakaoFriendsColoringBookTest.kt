package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class KakaoFriendsColoringBookTest {
    companion object {
        @JvmStatic
        fun coloringBookArgs() = Stream.of(
            Arguments.of(
                6, 4,
                arrayOf(
                    intArrayOf(1, 1, 1, 0),
                    intArrayOf(1, 2, 2, 0),
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(0, 0, 0, 3),
                    intArrayOf(0, 0, 0, 3),
                ),
                intArrayOf(4, 5)
            ),
            Arguments.of(
                6, 4,
                arrayOf(
                    intArrayOf(1, 1, 1, 0),
                    intArrayOf(1, 2, 2, 0),
                    intArrayOf(1, 0, 0, 1),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(0, 0, 0, 3),
                    intArrayOf(0, 3, 3, 3),
                ),
                intArrayOf(4, 5)
            ),
            Arguments.of(
                6, 4,
                arrayOf(
                    intArrayOf(1, 1, 1, 0),
                    intArrayOf(1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(0, 0, 0, 1),
                ),
                intArrayOf(2, 6)
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("coloringBookArgs")
    fun testSolution(m: Int, n: Int, picture: Array<IntArray>, result: IntArray) {
        assertArrayEquals(result, KakaoFriendsColoringBook().solution(m, n, picture))
    }
}
