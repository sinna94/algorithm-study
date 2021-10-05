package study.programmers.graph

import java.util.LinkedList

/*
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 * 2021-04-13
 */

fun farthestNode(n: Int, edge: Array<IntArray>): Int {
    val nodes: MutableList<Node> = mutableListOf()

    for (i in 1..n) {
        nodes.add(
            Node(
                i, false,
                edge.filter {
                    it[0] == i || it[1] == i
                }.map { if (it[0] == i) it[1] else it[0] }
            )
        )
    }

    val queue = LinkedList<Node>()
    nodes[0].visited = true
    queue.add(nodes[0])

    var distance = 0
    val distanceList = mutableListOf<Int>()

    // bfs 를 이용한 노드 시작점으로부터의 거리별 노드 수 확인
    while (!queue.isEmpty()) {
        distanceList.add(0)
        for (i in 0 until queue.count()) {
            val node = queue.poll()
            distanceList[distance] += 1
            node.nextNodes.forEach {
                nodes[it - 1].let { nextNode ->
                    if (!nextNode.visited) {
                        nextNode.visited = true
                        queue.add(nextNode)
                    }
                }
            }
        }
        distance++
    }

    return distanceList[distance - 1]
}

data class Node(
    val number: Int,
    var visited: Boolean = false,
    var nextNodes: List<Int>
)
