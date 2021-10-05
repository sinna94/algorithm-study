package study.codility.time_complexity

/*
 * 2021-02-23
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
fun permMissingElem(A: IntArray): Int {
    val numberSet = A.toSet()

    var i = 1

    while (numberSet.contains(i) && i <= A.count()) {
        i++
    }

    return i
}
