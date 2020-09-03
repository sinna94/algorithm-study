import kotlin.test.assertEquals

/*
 * 2020-09-02
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */

class Carpet {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()

        for (i in 1..yellow) {
            for (j in 1..yellow) {
                if (i >= j && i * j == yellow && (i + 2) * (j + 2) - yellow == brown) {
                    return intArrayOf(i + 2, j + 2)
                }
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    listOf(
        Triple(10, 2, intArrayOf(4, 3)),
        Triple(8, 1, intArrayOf(3, 3)),
        Triple(24, 24, intArrayOf(8, 6))
    ).forEach {
        val result = Carpet().solution(
            it.first, it.second
        )
        assertEquals(
            it.third[0], result[0]
        )
        assertEquals(it.third[1], result[1])
    }
}
