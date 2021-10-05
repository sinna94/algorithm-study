/*
 * 2020-08-24
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */

class PracticeTest {
    fun solution(answers: IntArray): IntArray {
        val first = listOf(1, 2, 3, 4, 5)
        val second = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        val third = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        var firstCnt = 0
        var secondCnt = 0
        var thirdCnt = 0

        answers.forEachIndexed { i, answer ->
            if (answer == first[i % first.count()])
                firstCnt++
            if (answer == second[i % second.count()])
                secondCnt++
            if (answer == third[i % third.count()])
                thirdCnt++
        }

        val results = intArrayOf(firstCnt, secondCnt, thirdCnt)
        val max = results.maxOrNull()
        return results.filter { result ->
            result == max
        }.withIndex().map { (i) -> i + 1 }.toIntArray()
    }
}
