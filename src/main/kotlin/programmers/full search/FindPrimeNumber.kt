
/*
 * 2020-09-02
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */

class FindPrimeNumber {
    fun solution(numbers: String): Int {
        val numberValues = numbers.map { it.toString() }
        val numbersGroup = numbers.groupBy { it }
        val numberList = ArrayList<String>()
        val newNumberList = ArrayList<String>()

        for (i in 0 until numbers.count()) {
            if (numberList.isEmpty()) {
                numberValues.forEach {
                    numberList.add(it)
                }
            } else {
                numberList.forEach { n ->
                    newNumberList += numberValues.map { v ->
                        n + v
                    }
                }
                numberList += newNumberList
            }
        }

        return numberList.filter { s ->
            s.groupBy { it }.all {
                it.value.count() <= numbersGroup[it.key]?.count() ?: 0
            } && isPrime(s.toInt())
        }.map { it.toInt() }.toSet().count()
    }

    private fun isPrime(num: Int): Boolean {
        if (num <= 1)
            return false
        if (num == 2)
            return true

        if ((num % 2) == 0)
            return false

        var i = 3

        while (i * i <= num) {
            if (num % i == 0)
                return false
            i++
        }
        return true
    }
}

fun main(args: Array<String>) {
//    listOf(Pair("011", 2), Pair("17",3), Pair("2",1)).forEach {
//        assertEquals(it.second, FindPrimeNumber().solution(
//            it.first
//        ))
//    }
}
