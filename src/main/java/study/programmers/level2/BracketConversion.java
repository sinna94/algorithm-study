package study.programmers.level2;

import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 * 2021-10-5
 */
public class BracketConversion {
  public String solution(String p) {
    return convertCollectString(p);
  }

  @NotNull
  private String convertCollectString(String p) {

    if(p.isEmpty()){
      return "";
    }

    int[] bracketArr = new int[2];

    String balancedBracketString = "";
    String subString = p;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < subString.length(); i++) {
      char bracket = subString.charAt(i);
      bracketArr[bracket - '('] += 1;
      if (bracketArr[0] > 0 && bracketArr[1] > 0 && bracketArr[0] == bracketArr[1]) {
        balancedBracketString = subString.substring(0, i + 1);
        subString = subString.substring(i + 1);
        break;
      }
    }

    boolean isCorrect = isCorrectString(balancedBracketString);

    if (!isCorrect) {
      String subStringResult = convertCollectString(subString);
      stringBuilder
        .append("(")
        .append(subStringResult)
        .append(")")
        .append(getMiddleString(balancedBracketString).chars().mapToObj(this::reverseBracket).collect(Collectors.joining()));
    } else {
      stringBuilder.append(balancedBracketString).append(convertCollectString(subString));
    }

    return stringBuilder.toString();
  }

  @NotNull
  private String getMiddleString(String balancedBracketString) {
    return balancedBracketString.substring(1, balancedBracketString.length() - 1);
  }

  private String reverseBracket(int bracket) {
    if (bracket == '(') {
      return ")";
    }
    return "(";
  }

  private boolean isCorrectString(String balancedBracketString) {
    int openBracketCount = 0;

    for (int i = 0; i < balancedBracketString.length(); i++) {
      if (balancedBracketString.charAt(i) == '(') {
        openBracketCount += 1;
      } else {
        if (openBracketCount == 0) {
          return false;
        }
        openBracketCount -= 1;
      }
    }
    return true;
  }
}
