package study.programmers.dfs_bfs

/*
 * 2021-01-17
 * https://programmers.co.kr/learn/courses/30/lessons/43164?language=kotlin
 */

fun travelRoute(tickets: Array<Array<String>>): Array<String> {

    // route 를 맵으로 생성
    val routeMap = mutableMapOf<String, Route>()
    tickets.forEach {
        val start = it[0]
        val dest = it[1]
        val routeString = "$start-$dest"
        val route = routeMap[routeString]
        if (route == null) {
            routeMap[routeString] = Route(start, dest, 0, emptyList(), 1)
        } else {
            route.count = route.count + 1
        }
    }

    // 모든 route 에 dest 로 시작하는 route 를 다음 route 로 추가
    tickets.forEach { ticket ->
        val start = ticket[0]
        val dest = ticket[1]
        val routeString = "$start-$dest"

        routeMap[routeString]?.nextRoutes = routeMap.filter {
            it.value.start == dest
        }.map { it.value }
    }

    // route 탐색
    return routeMap.map { (airport, route) ->
        if (airport.startsWith("ICN")) {
            // 모든 route visited 를 false 로 초기화
            routeMap.values.forEach { it.visitedCount = 0 }
            searchRoute(route, tickets.count(), mutableListOf(route.start))
        } else {
            emptyArray()
        }
    }.filter { it.isNotEmpty() }
        .minByOrNull { it.joinToString() } ?: emptyArray()
}

fun searchRoute(node: Route, target: Int, history: MutableList<String>): Array<String> {
    node.visitedCount = node.visitedCount + 1
    val nextRoutes = node.nextRoutes
    var result: Array<String> = arrayOf()

    nextRoutes.sortedByDescending { it.dest }.forEach {
        if (it.visitedCount < it.count) {
            val start = it.start
            // history 복사
            val newHistory = history.map { h -> h }.toMutableList()
            newHistory.add(start)

            if (history.count() != target) {
                searchRoute(it, target, newHistory).let { searchResult ->
                    if (searchResult.isNotEmpty()) {
                        result = searchResult
                    }
                }
                // 백트래킹
                it.visitedCount = it.visitedCount - 1
            }
        }
    }

    if (history.count() == target) {
        history.add(node.dest)
        result = history.toTypedArray()
    }
    return result
}

data class Route(
    val start: String,
    val dest: String,
    var visitedCount: Int,
    var nextRoutes: List<Route>,
    var count: Int
) {
    override fun toString(): String {
        return "$start-$dest"
    }
}
