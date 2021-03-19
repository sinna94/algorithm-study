/*
 * https://programmers.co.kr/learn/courses/30/lessons/42860?language=kotlin
 * 2021-03-19
 */

package study.programmers.greedy

import kotlin.math.abs
import kotlin.math.min

fun joyStick(name: String): Int {
  if (name == "A") return 0

  var answer = 0
  val a = 'A'
  // A -> Z 로 가려면 한단계가 있기 때문에 Z 문자 보다 하나 큰 문자로 초기화
  val z = 'Z' + 1
  var loc = 0
  val nameLength = name.count()
  val lastIndex = name.count() - 1
  // name 의 길이만큼의 char 배열을 A 문자로 초기화
  val alphabetArray = CharArray(name.count()) { i -> 'A' }
  val nameCharArray = name.toCharArray()
  // 좌우 방향
  var direction = 1
  val targets = nameCharArray.mapIndexed { index, c ->
    if (c != a) {
      index
    } else {
      null
    }
  }.mapNotNull { it }.toMutableSet()

  if (targets.count() == 0) {
    return 0
  }

  // 위에서 초기화한 배열이 원래 name 과 동일할 때까지 반복
  while (!alphabetArray.contentEquals(nameCharArray)) {
    targets.remove(loc)
    val alphabetChar = alphabetArray[loc]
    val nameChar = nameCharArray[loc]

    // 문자 비교 후 변경
    if (alphabetChar != nameChar) {
      // 올려서 변경하는 수
      val upCount = nameChar - a
      // 내려서 변경하는 수
      val downCount = (z - nameChar)

      answer += if (upCount <= downCount) {
        upCount
      } else {
        downCount
      }

      alphabetArray[loc] = nameChar


    }
    // 현재 위치에서 앞에서 최소거리, 뒤에서 최소거리 중 작은 값 반환
    var targetIndex = targets.minBy {
      min(abs(it - loc), abs(lastIndex - it + loc))
    } ?: 0
    val rightCount = targetIndex - loc
    val leftCount = loc + nameLength - targetIndex

    direction = if (rightCount in 1..leftCount) {
      1
    } else {
      -1
    }
    // 이동시 + 1
    if (loc <= lastIndex) {
      answer++
    }


    // 처음에서 왼쪽으로 이동시 마지막으로 이동
    if (loc == 0 && direction == -1) {
      loc = lastIndex
    } else {
      loc += direction
    }
  }

  return answer - 1
}
