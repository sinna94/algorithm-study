package study.programmers.level1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ClawMachineTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(0, 0, 0, 0, 0),
                        intArrayOf(0, 0, 1, 0, 3),
                        intArrayOf(0, 2, 5, 0, 1),
                        intArrayOf(4, 2, 4, 4, 2),
                        intArrayOf(3, 5, 1, 3, 1)
                    ),
                    intArrayOf(1, 5, 3, 5, 1, 2, 1, 4),
                    4
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(board: Array<IntArray>, moves: IntArray, result: Int) {
        assertEquals(result, ClawMachine().solution(board, moves))
    }
}
