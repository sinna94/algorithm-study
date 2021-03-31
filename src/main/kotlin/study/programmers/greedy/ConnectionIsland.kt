package study.programmers.greedy

/*
 * 2021-04-03
 * https://programmers.co.kr/learn/courses/30/lessons/42861?language=kotlin
 * union-find
 * kruskal algorithm
 * 최소 신장 트리
 */

fun connectingIsland(n: Int, costs: Array<IntArray>): Int {
  var answer = 0
  val parents = IntArray(n) { i -> i }

  costs.sortBy { it[2] }

  costs.forEach { cost ->
    if (!findParent(parents, cost[0], cost[1])) {
      answer += cost[2]
      unionParent(parents, cost[0], cost[1])
    }
  }

  return answer
}

// 부모 찾기
fun getParent(parents: IntArray, x: Int): Int {
  return if (parents[x] == x) {
    x
  } else {
    parents[x] = getParent(parents, parents[x])
    parents[x]
  }
}

// 작은 쪽으로 부모 합치기
fun unionParent(parents: IntArray, a: Int, b: Int) {
  val p1 = getParent(parents, a)
  val p2 = getParent(parents, b)
  if (p1 < p2) {
    parents[p2] = p1
  } else {
    parents[p1] = p2
  }
}

// 같은 부모를 같는지 확인
fun findParent(parents: IntArray, a: Int, b: Int): Boolean {
  val p1 = getParent(parents, a)
  val p2 = getParent(parents, b)
  return p1 == p2
}
