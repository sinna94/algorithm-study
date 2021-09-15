package study.programmers.level1;

/*
 *  https://programmers.co.kr/learn/courses/30/lessons/81301
 *  2021-09-15
 */
public class NumStringAndWord {
  public int solution(String s) {
    String[] numberString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String temp = s;
    for (int i = 0; i < numberString.length; i++) {
      temp = temp.replaceAll(numberString[i], String.valueOf(i));
    }
    return Integer.parseInt(temp);
  }
}
