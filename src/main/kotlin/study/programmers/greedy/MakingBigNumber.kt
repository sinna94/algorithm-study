package study.programmers.greedy

import java.util.Stack

/**
 * 2020-03-25
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */

fun solution(number: String, k: Int): String {

    val stack: Stack<Char> = Stack()
    var removeCount = 0

    number.forEach {
        while (!stack.isEmpty() && stack.peek() < it && removeCount < k) {
            stack.pop()
            removeCount += 1
        }
        stack.push(it)
    }

    while (removeCount < k) {
        stack.pop()
        removeCount += 1
    }

    return stack.joinToString("")
}

/* 통과는 하지만 틀린 답 */
// fun solution(number: String, k: Int): String {
//  var removeCnt = 0
//  var i = 0
//  var answer = StringBuilder(number)
//  var len = answer.count()
//
//  while (removeCnt < k) {
//    if (i == len - 1) {
//      return answer.substring(0, len-k)
//    }
//
//    if (answer[i] < answer[i + 1]) {
//      answer.delete(i, i + 1)
//      removeCnt += 1
//      i = -1
//      len -= 1
//    }
//    i += 1
//  }
//  return answer.toString()
// }
