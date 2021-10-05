package study.programmers.level1

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SecretMapTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    5, intArrayOf(9, 20, 28, 18, 11), intArrayOf(30, 1, 21, 17, 28), arrayOf("#####", "# # #", "### #", "#  ##", "#####")
                ),
                Arguments.of(
                    6,
                    intArrayOf(46, 33, 33, 22, 31, 50),
                    intArrayOf(27, 56, 19, 14, 14, 10),
                    arrayOf("######", "###  #", "##  ##", " #### ", " #####", "### # ")
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(n: Int, arr1: IntArray, arr2: IntArray, result: Array<String>) {
        Assertions.assertArrayEquals(result, SecretMap().solution(n, arr1, arr2))
    }
}
