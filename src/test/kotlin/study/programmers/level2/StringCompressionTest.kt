package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class StringCompressionTest {
    companion object {
        @JvmStatic
        fun stringCompressionArgs() = Stream.of(
            Arguments.of("aabbaccc", 7),
            Arguments.of("ababcdcdababcdcd", 9),
            Arguments.of("abcabcdede", 8),
            Arguments.of("abcabcabcabcdededededede", 14),
            Arguments.of("xababcdcdababcdcd", 17),
            Arguments.of("x", 1),
            Arguments.of("xxxxxxxxxxyyy", 5),
        )
    }

    @MethodSource("stringCompressionArgs")
    @ParameterizedTest
    fun testStringCompression(s: String, result: Int) {
        assertEquals(result, stringCompression(s))
    }
}
