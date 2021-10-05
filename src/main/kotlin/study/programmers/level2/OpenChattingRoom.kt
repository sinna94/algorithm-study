package study.programmers.level2

/*
 * 2020-05-20
 * https://programmers.co.kr/learn/courses/30/lessons/42888?language=kotlin
 */

fun openChattingRoom(record: Array<String>): Array<String> {

    val hiMessage = "님이 들어왔습니다."
    val byeMessage = "님이 나갔습니다."

    val userMap = mutableMapOf<String, String>()
    val answer = mutableListOf<Pair<String, String>>()

    record.forEach {
        val messageList = it.split(" ")
        when (messageList[0]) {
            "Enter" -> {
                userMap[messageList[1]] = messageList[2]
                answer.add(Pair(messageList[1], hiMessage))
            }
            "Leave" -> {
                answer.add(Pair(messageList[1], byeMessage))
            }
            "Change" -> {
                userMap[messageList[1]] = messageList[2]
            }
        }
    }

    return answer.map { userMap[it.first] + it.second }.toTypedArray()
}
