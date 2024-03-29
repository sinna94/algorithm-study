package study.programmers.level1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class NewIdRecommendTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "...!@BaT#*..y.abcdefghijklm,bat.y.abcdefghi",
            "z-+.^.,z--",
            "=.=,aaa",
            "123_.def,123_.def",
            "abcdefghijklmn.p,abcdefghijklmn"
        ]
    )
    fun testLottoHighLow(newId: String, result: String) {
        assertEquals(result, NewIdRecommend().solution(newId))
    }
}
