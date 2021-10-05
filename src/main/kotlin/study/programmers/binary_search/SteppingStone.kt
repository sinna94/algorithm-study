package study.programmers.binary_search

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43236
 * 2021-04-09
 */

// n개의 돌을 없애서 돌 사이의 거리의 최솟값이 x 로 만들 수 있는가?
fun steppingStone(distance: Int, rocks: IntArray, n: Int): Int {
    rocks.sort()
    var answer = 0
    var start = 0
    var end = distance
    var mid: Int
    // 0 2 11 14 17 25

    while (start <= end) {
        // 기준 거리 : x
        mid = (start + end) / 2
        var removeCnt = 0
        var prevRock = 0

        rocks.forEach {
            val betweenDistance = it - prevRock
            if (mid > betweenDistance) {
                // 기준값보다 크면 돌 제거
                removeCnt += 1
            } else {
                prevRock = it
            }
        }

        if (n >= removeCnt) {
            if (answer < mid) {
                answer = mid
            }
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    return answer
}
