package study.programmers

import FunctionDevelopment
import IronBar
import Printer
import TruckPassingTheBridge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import study.programmers.stack_queue.Tower
import java.util.stream.Stream

class StackQueueTest {
  companion object {
    @JvmStatic
    fun truckArgs() = Stream.of(
      Arguments.of(8, 2, 10, intArrayOf(7, 4, 5, 6)),
      Arguments.of(101, 100, 100, intArrayOf(10)),
      Arguments.of(110, 100, 100, intArrayOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10))
    )
  }

  @ParameterizedTest
  @MethodSource("truckArgs")
  fun testTruckPassingTheBridgeTest(expected: Int, bridge_length: Int, weight: Int, truck_weights: IntArray) {
    val result = TruckPassingTheBridge().solution(
      bridge_length, weight, truck_weights
    )
    assertEquals(expected, result)
  }

  @Test
  fun testFunctionDevelopmentTest() {
    val result = FunctionDevelopment().solution(
      intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)
    )
    val expected = intArrayOf(2, 1)
    assertEquals(expected.count(), result.count())
    result.forEachIndexed { index, r ->
      assertEquals(expected[index], r)
    }
  }

  @Test
  fun testIronBarTest() {
    val result = IronBar().solution(
      "()(((()())(())()))(())"
    )
    val expected = 17
    assertEquals(expected, result)
  }

  @Test
  fun testPrinterTest() {
    val result = Printer().solution(
      intArrayOf(2, 1, 3, 2),
      2
    )
    val expected = 1
    assertEquals(expected, result)
  }

  @Test
  fun testTowerTest() {
    val result = Tower().solution(
      intArrayOf(3, 9, 9, 3, 5, 7, 2)
    )
    val expected = intArrayOf(0, 0, 0, 3, 3, 3, 6)
    assertEquals(expected.count(), result.count())
    result.forEachIndexed { index, r ->
      assertEquals(expected[index], r)
    }
  }
}
