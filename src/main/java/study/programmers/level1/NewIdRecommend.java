package study.programmers.level1;

/*
 *  https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
 *  2021-09-15
 */
public class NewIdRecommend {
  public String solution(String new_id) {

    // step1
    String lowerCaseNewId = new_id.toLowerCase();
    // step2
    String removeString = lowerCaseNewId.replaceAll("(?![a-z0-9-_.]).", "");
    // step3
    String mergeDot = removeString.replaceAll("\\.{2,}", ".");
    // step4
    String removeFirstLastDot = mergeDot.replaceAll("(^\\.)|(\\.$)", "");
    //step5
    String ifEmptyString = removeFirstLastDot.isBlank() ? "a" : removeFirstLastDot;
    //step6
    String substring = ifEmptyString.length() >= 16 ? ifEmptyString.substring(0, 15).replaceAll("\\.$", "") : ifEmptyString;
    //step7
    StringBuilder answer = new StringBuilder(substring);

    if (substring.length() < 3) {
      char lastChar = substring.charAt(substring.length() - 1);
      answer.append(String.valueOf(lastChar).repeat(3 - substring.length()));
    }

    return answer.toString();
  }
}
