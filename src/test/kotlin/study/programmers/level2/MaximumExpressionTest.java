package study.programmers.level2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumExpressionTest {

    @CsvSource(value = {
        "100-200*300-500+20,60420",
        "50*6-3*2,300"
    })
    @ParameterizedTest
    void solution(String expression, Long expected) {
        assertEquals(expected, new MaximumExpression().solution(expression));
    }
}
