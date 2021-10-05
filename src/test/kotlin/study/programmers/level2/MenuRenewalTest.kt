package study.programmers.level2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MenuRenewalTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"),
                    intArrayOf(2, 3, 4),
                    arrayOf("AC", "ACDE", "BCFG", "CDE"),
                ),
                Arguments.of(
                    arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"),
                    intArrayOf(2, 3, 5),
                    arrayOf("ACD", "AD", "ADE", "CD", "XYZ"),
                ),
                Arguments.of(
                    arrayOf("XYZ", "XWY", "WXA"),
                    intArrayOf(2, 3, 4),
                    arrayOf("WX", "XY"),
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(orders: Array<String>, course: IntArray, result: Array<String>) {
        Assertions.assertArrayEquals(result, MenuRenewal().solution(orders, course))
    }
}
