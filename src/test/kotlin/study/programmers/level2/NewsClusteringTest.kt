package study.programmers.level2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class NewsClusteringTest {
    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "FRANCE", "french", 16384
                ),
                Arguments.of(
                    "FRANCE_", "french", 16384
                ),
                Arguments.of(
                    "handshake", "shake hands", 65536
                ),
                Arguments.of(
                    "aa1+aa2", "AAAA12", 43690
                ),
                Arguments.of(
                    "E=M*C^2", "e=m*c^2", 65536
                ),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    fun test(str1: String, str2: String, result: Int) {
        assertEquals(result, NewsClustering().solution(str1, str2))
    }
}
