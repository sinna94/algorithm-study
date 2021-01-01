package study.programmers.dfs_bfs

/*
 * 2020-12-16
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */

fun network(n: Int, computers: Array<IntArray>): Int {
  // index set 의 set 생성
  val networkSet: Set<Set<Int>> = computers.map { c ->
    c.toList().mapIndexedNotNull { i, n ->
      if (n == 1) {
        i
      } else {
        null
      }
    }.toSet()
  }.toSet()
  println(networkSet)
  // 네트워크 set 의 set 생성
  val networkResultSet: MutableSet<MutableSet<Int>> = mutableSetOf()

  // index Set 루프 돌면서 겹치는 index 가 있으면 합치기
  networkSet.forEach { set ->
    // 네트워크 set 수가 컴퓨터 개수와 같으면 모두 연결된 네트워크이므로 1 반환
    if (set.count() == n) {
      return 1
    }

    // 새로운 네트워크가 발견되면 저장할 newSet 생성
    val newSet = mutableSetOf<Int>()
    // 모든 index Set 끼리 비교
    networkSet.forEach { network ->
      var isNew = true
      println("network:$network")
      // 결과 Set 과 겹치는 index 가 있으면 합치기
      networkResultSet.forEach {
        if ((network intersect it).count() > 0) {
          it.addAll(network)
          println("result: $it")
          isNew = false
        }
      }
      // 결과 Set 에 없고 다른 set 과 겹치는 항목(자기 자신 포함)은 newSet 에 추가
      if (isNew && (set intersect network).count() > 0) {
        newSet.addAll(network)
        println("new: $newSet")
      }
    }
    // newSet 의 크기가 컴퓨터 수와 같으면 1 반환
    if (newSet.count() == n) {
      return 1
    }
    // newSet 에 데이터가 있으면 결과 Set 에 추가
    if (newSet.count() > 0)
      networkResultSet.add(newSet)
    println("networkList $networkResultSet")
  }
  println(networkResultSet)
  return networkResultSet.count()
}
