package study.programmers.callenges

import kotlin.math.pow

class Third {
    fun solution(n: Int): Int {
        var num = n
        var str = ""
        while (num > 3) {
            str += num % 3
            num /= 3
        }
        str += num
        val count = str.count() - 1
        var i = 0
        return str.sumBy {
            val digit = it.toInt() - 48
            val value = (3.0).pow(count - i++)
            (digit * value).toInt()
        }
    }
}

fun main() {
    val result = Third().solution(
        100000000
    )
    println(result)
}
