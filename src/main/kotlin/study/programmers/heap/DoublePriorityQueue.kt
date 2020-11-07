package study.programmers.heap

import java.util.PriorityQueue

/*
 * 2020-11-07
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */

fun solveDoublePriorityQueue(operations: Array<String>): IntArray {
  val minQueue = PriorityQueue<Int> { n1, n2 -> n1 - n2 }
  val maxQueue = PriorityQueue<Int> { n1, n2 -> n2 - n1 }

  operations.forEach {
    val (arg, numStr) = it.split(" ")
    val num = numStr.toInt()
    if (arg == "I") {
      minQueue.add(num)
      maxQueue.add(num)
    }
    if (arg == "D") {
      if (num == 1) {
        val max = maxQueue.poll()
        minQueue.remove(max)
      }
      if (num == -1) {
        val min = minQueue.poll()
        maxQueue.remove(min)
      }
    }
  }

  return if (minQueue.count() == 0) {
    intArrayOf(0, 0)
  } else {
    intArrayOf(maxQueue.poll(), minQueue.poll())
  }
}
