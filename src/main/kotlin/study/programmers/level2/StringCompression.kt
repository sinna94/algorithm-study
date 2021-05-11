package study.programmers.level2

import java.lang.StringBuilder

/*
 * 2021-05-11
 * https://programmers.co.kr/learn/courses/30/lessons/60057?language=kotlin
 */

fun stringCompression(s: String): Int {
  var answer = s.count()

  for (i in 1..s.count() / 2) {
    val slicedList = mutableListOf<String>()
    val compressedStringBuilder = StringBuilder()

    var prevSlicedString = ""
    var prevSlicedStringCount = 0

    for (j in 0 until (s.count() / i) + 1) {
      val end = if (j * i + i > s.count()) {
        s.count()
      } else {
        j * i + i
      }
      val slicedString = s.slice(j * i until end)
      slicedList.add(slicedString)

      if (prevSlicedString != "") {
        if (prevSlicedString == slicedString) {
          prevSlicedStringCount += 1
        } else {
          val repetitionCountString = if (prevSlicedStringCount == 0) {
            ""
          } else {
            prevSlicedStringCount + 1
          }
          compressedStringBuilder.append("${repetitionCountString}$prevSlicedString")
          prevSlicedStringCount = 0
        }
      }

      prevSlicedString = slicedString
    }
    val repetitionCountString = if (prevSlicedStringCount == 0) {
      ""
    } else {
      prevSlicedStringCount + 1
    }

    compressedStringBuilder.append("${repetitionCountString}$prevSlicedString")
    val compressedSize = compressedStringBuilder.toString().count()

    if (compressedSize < answer) {
      answer = compressedSize
    }
  }

  return answer
}
