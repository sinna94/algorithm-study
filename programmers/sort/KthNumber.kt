class KthNumber {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.slice(IntRange(it[0] - 1, it[1] - 1)).sorted()[it[2] - 1]
        }.toIntArray()
    }
}

fun main(args: Array<String>) {
    val result = KthNumber().solution(
        intArrayOf(1, 5, 2, 6, 3, 7, 4),
        arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    )
    println(result.toList())
}
