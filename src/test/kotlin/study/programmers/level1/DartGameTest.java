package study.programmers.level1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DartGameTest {

    @CsvSource(value={
        "1S2D*3T,37",
        "1D2S#10S,9",
        "1D2S0T,3",
        "1S*2T*3S,23",
        "1D#2S*3S,5",
        "1T2D3D#,-4",
        "1D2S3T*,59",
        "2S*2T*,24",
        "10S10S,20",
        "0S10D,100",
    })
    @ParameterizedTest
    void solution(String dartResult, int expected) {
        assertEquals(expected, new DartGame().solution(dartResult));
    }
}
