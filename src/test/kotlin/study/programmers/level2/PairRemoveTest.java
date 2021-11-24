package study.programmers.level2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PairRemoveTest {

    @CsvSource(value={
        "baabaa,1",
        "cdcd,0",
        "bcbccbcb,1"
    })
    @ParameterizedTest
    void solution(String s, int expected) {
        assertEquals(expected, new PairRemove().solution(s));
    }
}
