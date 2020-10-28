class HIndex {
    fun solution(citations: IntArray): Int {
        var result = 0
        val sortedList = citations.sortedDescending()
        val max = citations.max() ?: 0
        for (i in 0..max) {
            val index = sortedList.indexOfLast { it >= i } + 1
            if (index > result) {
                result = i
            }
        }
        return result
    }
}

fun main() {
    val result = HIndex().solution(
//        intArrayOf(3, 0, 6, 1, 5)
    intArrayOf(5,5,5,5)
    )
    println(result)
}
