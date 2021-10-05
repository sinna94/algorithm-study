package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class OpenChattingRoomKtTest {
    companion object {
        @JvmStatic
        fun openChattingRoomArgs() = Stream.of(
            Arguments.of(
                arrayOf(
                    "Enter uid1234 Muzi",
                    "Enter uid4567 Prodo",
                    "Leave uid1234",
                    "Enter uid1234 Prodo",
                    "Change uid4567 Ryan"
                ),
                arrayOf(
                    "Prodo님이 들어왔습니다.",
                    "Ryan님이 들어왔습니다.",
                    "Prodo님이 나갔습니다.",
                    "Prodo님이 들어왔습니다."
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("openChattingRoomArgs")
    fun openChattingRoom(record: Array<String>, result: Array<String>) {
        assertArrayEquals(result, openChattingRoom(record))
    }
}
