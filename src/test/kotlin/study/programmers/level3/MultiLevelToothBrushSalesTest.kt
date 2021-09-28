package study.programmers.level3

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.level1.SecretMap
import java.util.stream.Stream

class MultiLevelToothBrushSalesTest {
  companion object {
    @JvmStatic
    fun args(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(
          arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"),
          arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"),
          arrayOf("young", "john", "tod", "emily", "mary"),
          intArrayOf(12, 4, 2, 5, 10),
          intArrayOf(360, 958, 108, 0, 450, 18, 180, 1080)
        ),
        Arguments.of(
          arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"),
          arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"),
          arrayOf("sam", "emily", "jaimie", "edward"),
          intArrayOf(2, 3, 5, 4),
          intArrayOf(0, 110, 378, 180, 270, 450, 0, 0)
        ),
      )
    }
  }


  @ParameterizedTest
  @MethodSource("args")
  fun test(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray, result: IntArray) {
    Assertions.assertArrayEquals(result, MultiLevelToothBrushSales().solution(enroll, referral, seller, amount))
  }
}
