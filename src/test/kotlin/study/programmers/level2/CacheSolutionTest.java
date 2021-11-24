package study.programmers.level2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CacheSolutionTest {
    static Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 50),
            Arguments.of(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}, 21),
            Arguments.of(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 60),
            Arguments.of(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}, 52),
            Arguments.of(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}, 16),
            Arguments.of(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}, 25)
        );
    }

    @MethodSource("args")
    @ParameterizedTest
    void solution(int cacheSize, String[] cities, int expected) {
        assertEquals(expected, new CacheSolution().solution(cacheSize, cities));
    }
}
