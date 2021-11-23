package study.programmers.level2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FriendsBlockTest {

    static Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}, 14),
            Arguments.of(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}, 15)
        );
    }

    @MethodSource("args")
    @ParameterizedTest
    void solution(int m, int n, String[] board, int expected) {
        assertEquals(expected, new FriendsBlock().solution(m, n, board));
    }
}
