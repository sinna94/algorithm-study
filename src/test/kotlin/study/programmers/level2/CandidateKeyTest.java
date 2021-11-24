package study.programmers.level2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CandidateKeyTest {

    static Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(
                new String[][]{
                    {"100", "ryan", "music", "2"},
                    {"200", "apeach", "math", "2"},
                    {"300", "tube", "computer", "3"},
                    {"400", "con", "computer", "4"},
                    {"500", "muzi", "music", "3"},
                    {"600", "apeach", "music", "2"}
                }, 2
            ),
            Arguments.of(
                new String[][]{
                    {"a", "1", "aaa", "c", "ng"},
                    {"a", "1", "bbb", "e", "g"},
                    {"c", "1", "aaa", "d", "ng"},
                    {"d", "2", "bbb", "d", "ng"}
                }, 5
            )
        );
    }

    @MethodSource("args")
    @ParameterizedTest
    void solution(String[][] relation, int expected) {
        assertEquals(expected, new CandidateKey().solution(relation));
    }
}
