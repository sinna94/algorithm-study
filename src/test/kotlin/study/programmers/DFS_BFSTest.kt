package study.programmers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.DFS_BFS.targetNumber
import java.util.stream.Stream

class DFS_BFSTest{
    companion object {
        @JvmStatic
        fun targetNumberArgs(): Stream<Arguments> = Stream.of(
            Arguments.of(intArrayOf(1,1,1,1,1), 3, 5)
        )
    }

    @ParameterizedTest
    @MethodSource("targetNumberArgs")
    fun testTargetNumber(numbers: IntArray, target: Int, answer: Int){
        assertEquals(answer, targetNumber(numbers, target))
    }
}