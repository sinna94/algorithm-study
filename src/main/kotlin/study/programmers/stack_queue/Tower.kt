package study.programmers.stack_queue
/*
 * 2020-07-27
 * https://programmers.co.kr/learn/courses/30/lessons/42588?language=kotlin
 */

class Tower {
    fun solution(heights: IntArray): IntArray {
        val reversedHeights = heights.reversed()

        return reversedHeights.mapIndexed { i, h ->
            val index = reversedHeights.slice(0 + i + 1 until heights.count()).indexOfFirst {
                it > h
            }
            if (index > -1) {
                heights.count() - index - i - 1
            } else {
                0
            }
        }.reversed().toIntArray()
    }
}
