/*
 * 2020-07-28
 * https://programmers.co.kr/learn/courses/30/lessons/42585
 */

class IronBar {
    fun solution(arrangement: String): Int {
        var answer = 0
        var prev: Char? = null
        var ironBarCount = 0

        arrangement.forEach {
            if (it == '(') {
                ironBarCount += 1
            }

            if (it == ')') {
                --ironBarCount

                answer += if (prev == '(') {
                    ironBarCount
                } else {
                    1
                }
            }
            prev = it
        }

        return answer
    }
}
