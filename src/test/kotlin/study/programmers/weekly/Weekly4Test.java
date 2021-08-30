package study.programmers.weekly;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Weekly4Test {
  static Stream<Arguments> weekly4Args() {
    return Stream.of(
      Arguments.of(
        new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
        new String[]{"PYTHON", "C++", "SQL"},
        new int[]{7, 5, 5},
        "HARDWARE"
      ),
      Arguments.of(
        new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
        new String[]{"JAVA", "JAVASCRIPT"},
        new int[]{7, 5},
        "PORTAL"
      )
    );
  }


  @ParameterizedTest
  @MethodSource("weekly4Args")
  void solution(String[] table, String[] languages, int[] preference, String result) {
    assertEquals(result, new Weekly4().solution(table, languages, preference));
  }
}
