import kotlin.math.ceil

/*
 * 2020-08-05
 * https://programmers.co.kr/learn/courses/30/lessons/42586?language=kotlin
 */
class FunctionDevelopment {
  fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    val answer = ArrayList<Int>()
    val workingDays = progresses.mapIndexed { i, progress ->
      ceil((100 - progress).div(speeds[i].toDouble())).toInt()
    }

    var prevWork = workingDays.first()
    var cnt = 1

    workingDays.slice(1 until workingDays.count()).forEach {
      when {
        prevWork < it -> {
          answer.add(cnt)
          prevWork = it
          cnt = 1
        }
        prevWork >= it -> {
          cnt++
        }
      }
    }
    answer.add(cnt)
    return answer.toIntArray()
  }
}

fun main() {
  val result = FunctionDevelopment().solution(
    intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)
  )
  println(result.toList())
}
