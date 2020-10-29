import java.util.LinkedList

/*
 * 2020-08-23
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */

class Printer {
    fun solution(priorities: IntArray, location: Int): Int {
        val queue = LinkedList(priorities.toList())
        var index = location
        var answer = 1

        while (!queue.isEmpty()) {
            val priority = queue.pop()
            val checkPriority = queue.find {
                it > priority
            }
            
            if (checkPriority !== null) {
                // 가장 앞의 문서가 맨 뒤로 가는 경우
                queue.addLast(priority)
                if (index == 0) {
                    // 내 문서
                    // 내 순서 맨 뒤로
                    val queueCount = queue.count()
                    index = queueCount - 1
                } else {
                    // 다른 사람 문서
                    // 내 순서 -1
                    index--
                }
            } else {
                // 가장 앞의 문서가 인쇄 되는 경우
                if (index == 0){
                    // 내 문서
                    return answer
                }
                else{
                    // 다른 사람 문서
                    index--
                    answer++
                }
            }
        }
        return answer
    }
}
