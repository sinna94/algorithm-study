package study.programmers.dfs_bfs

/*
 * 2021-01-01
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */

fun wordConversion(begin: String, target: String, words: Array<String>): Int {

    // words 에 target 이 없는 경우 0 반환
    if (!words.any { it == target }) {
        return 0
    }

    // begin 을 포함한 allWords 생성
    val allWords = words.plus(begin)

    // 각 단어별 노드 생성
    val nodeMap = allWords.associate { it to WordNode(it) }
    nodeMap.forEach { (word, node) ->
        // 한글자만 다른 단어를 찾아서 다음 노드로 추가
        findOneAlphabetDiff(word, allWords).forEach { diffWord ->
            nodeMap[diffWord]?.let {
                node.addNextWordNode(it)
            }
        }
    }

    nodeMap[begin].let {
        return if (it != null) {
            searchGraph(it, target, 1)
        } else {
            0
        }
    }
}

fun searchGraph(node: WordNode, target: String, depth: Int): Int {
    node.setVisited(true)
    val nextNodes = node.getNextWordNodes()
    var result: Int = Int.MAX_VALUE
    nextNodes.forEach {
        if (!it.getVisited()) {
            val word = it.getWord()
            val resultDepth = if (word == target) {
                depth
            } else {
                searchGraph(it, target, depth + 1)
            }
            if (result > resultDepth) {
                result = resultDepth
            }
        }
    }
    return result
}

fun findOneAlphabetDiff(word: String, words: Array<String>): List<String> {
    return words.filter { w ->
        w.withIndex().filter { it.value != word[it.index] }.count() == 1
    }.map { it }
}

class WordNode(word: String) {
    private val word: String = word
    private val nextNodes: MutableList<WordNode> = mutableListOf()
    private var visited: Boolean = false

    fun getWord(): String {
        return this.word
    }

    fun addNextWordNode(wordNode: WordNode) {
        nextNodes.add(wordNode)
    }

    fun getNextWordNodes(): MutableList<WordNode> {
        return nextNodes
    }

    fun setVisited(visited: Boolean) {
        this.visited = visited
    }

    fun getVisited(): Boolean {
        return visited
    }
}
