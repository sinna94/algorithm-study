package study.programmers.weekly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateShortfallTest {

  @Test
  void solution() {
    long result = new CalculateShortfall().solution(3, 20, 4);
    assertEquals(10, result);
  }
}
