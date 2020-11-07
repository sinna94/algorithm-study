package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.heap.DiskController
import study.programmers.heap.MoreSpicy
import study.programmers.heap.solveDoublePriorityQueue
import java.util.stream.Stream

class HeapTest {
    @Test
    fun moreSpicyTest() {
        val result = MoreSpicy().solution(listOf(1, 2, 3, 9, 10, 12).toIntArray(), 7)
        assertEquals(2, result)
    }

    companion object {
        @JvmStatic
        fun diskControllerArgs(): Stream<Arguments> = Stream.of(
            Arguments.of(9, arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))),
            Arguments.of(9, arrayOf(intArrayOf(1, 10), intArrayOf(3, 3), intArrayOf(10, 3))),
            Arguments.of(15, arrayOf(intArrayOf(0, 10), intArrayOf(4, 10), intArrayOf(5, 11), intArrayOf(15, 2))),
            Arguments.of(10, arrayOf(intArrayOf(0, 10))),
            Arguments.of(9, arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6), intArrayOf(4, 3))),
            Arguments.of(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(500, 6))),
            Arguments.of(6, arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(500, 6))),
            Arguments.of(1, arrayOf(intArrayOf(0, 1), intArrayOf(0, 1), intArrayOf(1, 0))),
            Arguments.of(3, arrayOf(intArrayOf(0, 3), intArrayOf(4, 3), intArrayOf(8, 3))),
            Arguments.of(3, arrayOf(intArrayOf(0, 3), intArrayOf(4, 3), intArrayOf(10, 3))),
            Arguments.of(3, arrayOf(intArrayOf(0, 5), intArrayOf(6, 2), intArrayOf(6, 1))),
            Arguments.of(3, arrayOf(intArrayOf(0, 5), intArrayOf(6, 1), intArrayOf(6, 2))),
            Arguments.of(5, arrayOf(intArrayOf(0, 5), intArrayOf(2, 2), intArrayOf(5, 3))),
            Arguments.of(5, arrayOf(intArrayOf(0, 5), intArrayOf(2, 2), intArrayOf(4, 2))),
            Arguments.of(4, arrayOf(intArrayOf(0, 3), intArrayOf(0, 1), intArrayOf(4, 7))),
            Arguments.of(3, arrayOf(intArrayOf(0, 2), intArrayOf(3, 6), intArrayOf(3, 1))),
            Arguments.of(6, arrayOf(intArrayOf(0, 5), intArrayOf(1, 2), intArrayOf(5, 5))),
            Arguments.of(
                13,
                arrayOf(intArrayOf(0, 9), intArrayOf(0, 4), intArrayOf(0, 5), intArrayOf(0, 7), intArrayOf(0, 3))
            ),
            Arguments.of(
                72,
                arrayOf(
                    intArrayOf(24, 10),
                    intArrayOf(28, 39),
                    intArrayOf(43, 20),
                    intArrayOf(37, 5),
                    intArrayOf(47, 22),
                    intArrayOf(20, 47),
                    intArrayOf(15, 2),
                    intArrayOf(15, 34),
                    intArrayOf(35, 43),
                    intArrayOf(26, 1)
                )
            ),
            Arguments.of(
                72,
                arrayOf(
                    intArrayOf(24, 10),
                    intArrayOf(28, 39),
                    intArrayOf(43, 20),
                    intArrayOf(37, 5),
                    intArrayOf(47, 22),
                    intArrayOf(20, 47),
                    intArrayOf(15, 34),
                    intArrayOf(15, 2),
                    intArrayOf(35, 43),
                    intArrayOf(26, 1)
                )
            ),
            Arguments.of(
                13, arrayOf(intArrayOf(1, 9), intArrayOf(1, 4), intArrayOf(1, 5), intArrayOf(1, 7), intArrayOf(1, 3))
            )
        )

        @JvmStatic
        fun doublePriorityQueueArgs(): Stream<Arguments> = Stream.of(
            Arguments.of(arrayOf("I 16", "D 1"), intArrayOf(0, 0)),
            Arguments.of(arrayOf("I 7", "I 5", "I -5", "D -1"), intArrayOf(7, 5))
        )
    }

    @ParameterizedTest
    @MethodSource("diskControllerArgs")
    fun diskControllerTest(result: Int, jobs: Array<IntArray>) {
        assertEquals(result, DiskController().solution(jobs))
    }

    @ParameterizedTest
    @MethodSource("doublePriorityQueueArgs")
    fun testDoublePriorityQueue(operations: Array<String>, expected: IntArray) {
        val result = solveDoublePriorityQueue(operations)
        assertEquals(expected[0], result[0])
        assertEquals(expected[1], result[1])
    }
}
