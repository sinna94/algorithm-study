package study.programmers.dfs_bfs

/*
 * 2020-12-08
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */

var answer = 0

fun targetNumber(numbers: IntArray, target: Int): Int {
  answer = 0
  addNumber(0, numbers, 0, target)
  return answer
}

fun addNumber(sum: Int, numbers: IntArray, index: Int, target: Int) {
  if (numbers.count() == index) {
    if (sum == target)
      answer++
  } else {
    addNumber(sum + numbers[index], numbers, index + 1, target)
    addNumber(sum + numbers[index] * -1, numbers, index + 1, target)
  }
}
