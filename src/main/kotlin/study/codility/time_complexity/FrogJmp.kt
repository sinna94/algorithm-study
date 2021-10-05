package study.codility.time_complexity

import kotlin.math.ceil

/*
 * 2021-02-23
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
fun frogJmp(X: Int, Y: Int, D: Int): Int {

    val distance = Y - X

    return if (distance != 0) {
        ceil(distance.toDouble() / D).toInt()
    } else {
        0
    }
}
