package study.programmers.sort

class KthNumber {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        return commands.map {
            array.slice(IntRange(it[0] - 1, it[1] - 1)).sorted()[it[2] - 1]
        }.toIntArray()
    }
}
