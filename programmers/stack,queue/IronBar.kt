/*
 * 2020-07-28
 * https://programmers.co.kr/learn/courses/30/lessons/42585
 */

class IronBar {
    fun solution(arrangement: String): Int {
        /*
        val ironBarList = ArrayList<Int>()
        var answer = 0
        var prev:Char? = null
        arrangement.forEach {
            if(it == '('){
                ironBarList.add(1)
            }

            if(it == ')'){
                if(prev == '('){
                    val openCount = ironBarList.removeAt(ironBarList.count()-1) - 1
                    if(openCount > 0){
                        ironBarList.add(openCount)
                    }
                    ironBarList.add(0)
                }else{
                    ironBarList.add(-1)
                }
            }
            prev = it
        }

        var ironBarCount = 0
        ironBarList.forEach {
            if(it > 0){
                ironBarCount += 1
            }
            if(it < 0){
                answer += 1
                --ironBarCount
            }
            if(it == 0 && ironBarCount >0){
                answer += ironBarCount
            }
        }

        return answer
         */

        var answer = 0
        var prev: Char? = null
        var ironBarCount = 0

        arrangement.forEach {
            if (it == '(') {
                ironBarCount += 1
            }

            if (it == ')') {
                --ironBarCount

                answer += if (prev == '(') {
                    ironBarCount
                } else {
                    1
                }
            }
            prev = it
        }

        return answer
    }
}

fun main() {
    val result = IronBar().solution(
        "()(((()())(())()))(())"
    )
    println(result)
}
