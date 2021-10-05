package study.programmers.graph

/*
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 * 2021-04-14
 */

// 플로이드 워셜 알고리즘
fun ranking(n: Int, results: Array<IntArray>): Int {
    val infinity = 10_000_000
    val table = Array(n) { Array(n) { infinity } }

    // 자기 자신은 0으로 초기화
    for (i in 0 until n) {
        table[i][i] = 0
    }

    results.forEach {
        // 승
        table[it[0] - 1][it[1] - 1] = 1
    }

    table.forEach { arr ->
        println(arr.joinToString(","))
    }

    for (k in 0 until n) {
        for (a in 0 until n) {
            for (b in 0 until n) {
                table[a][b] = minOf(table[a][b], table[a][k] + table[k][b])
            }
        }
    }

    println("-------------")

    table.forEach { arr ->
        println(arr.joinToString(","))
    }

    var answer = 0
    for (a in 0 until n) {
        var count = 0
        for (b in 0 until n) {
            // 서로 한번이라도 싸운 적이 있는지 확인
            if (a != b && (table[a][b] != infinity || table[b][a] != infinity)) {
                count += 1
            }
        }
        if (count == n - 1) {
            answer += 1
        }
    }
    return answer
}
