package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.dynamic_programming.IntegerTriangle
import study.programmers.dynamic_programming.RoadToSchool
import study.programmers.dynamic_programming.Thievery
import study.programmers.dynamic_programming.expressedByN
import java.util.stream.Stream

class DynamicProgrammingTest {
    companion object {
        @JvmStatic
        fun expressedByNArgs(): Stream<Arguments> = Stream.of(
            Arguments.of(5, 12, 4),
            Arguments.of(2, 11, 3),
            Arguments.of(5, 31168, -1),
            Arguments.of(1, 1121, 7),
            Arguments.of(5, 3600, 6),
        )

        @JvmStatic
        fun integerTriangleArgs(): Stream<Arguments> = Stream.of(
            Arguments.of(
                arrayOf(intArrayOf(7), intArrayOf(3, 8), intArrayOf(8, 1, 0), intArrayOf(2, 7, 4, 4), intArrayOf(4, 5, 2, 6, 5)), 30
            )
        )

        @JvmStatic
        fun roadToSchoolArgs(): Stream<Arguments> = Stream.of(
            Arguments.of(4, 3, arrayOf(intArrayOf(2, 2)), 4)
        )

        @JvmStatic
        fun thieveryArgs(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 2, 3, 1), 4),
            Arguments.of(intArrayOf(1, 3, 2, 5, 3), 8),
            Arguments.of(intArrayOf(4, 4, 2, 1, 3), 7),
            Arguments.of(intArrayOf(11, 1, 9, 10, 9, 1), 29),
            Arguments.of(intArrayOf(11, 1, 3, 10, 4, 1), 21),
        )
    }

    @ParameterizedTest
    @MethodSource("expressedByNArgs")
    fun testExpressedByNArgs(N: Int, number: Int, answer: Int) {
        assertEquals(answer, expressedByN(N, number))
    }

    @ParameterizedTest
    @MethodSource("integerTriangleArgs")
    fun testIntegerTriangle(triangle: Array<IntArray>, answer: Int) {
        assertEquals(answer, IntegerTriangle().solution(triangle))
    }

    @ParameterizedTest
    @MethodSource("roadToSchoolArgs")
    fun testRoadToSchool(m: Int, n: Int, puddles: Array<IntArray>, answer: Int) {
        assertEquals(answer, RoadToSchool().solution(m, n, puddles))
    }

    @ParameterizedTest
    @MethodSource("thieveryArgs")
    fun testThievery(money: IntArray, answer: Int) {
        assertEquals(answer, Thievery().solution(money))
    }
}
