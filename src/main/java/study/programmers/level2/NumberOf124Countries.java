package study.programmers.level2;

/*
 * 2021-04-20
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class NumberOf124Countries {
  public String solution(int n) {
    int num = n;

    // 기본적으로 3진법을 생각한다.
    // 3진법은 0, 1, 2 로 구성되지만
    // 1, 2, 4 로 구성되도록 변경해야 한다.
    // 0 이 나올 때 4 가 들어가도록 변경한다.
    StringBuilder answer = new StringBuilder();
    while (num > 0) {
      if (num % 3 == 0) {
        // 3 의 배수일 때 나머지를 4로 설정하고
        // 다음 값을 (n-1)/로 넣어준다
        // ex) 9 일때 8/3
        num = (num - 1) / 3;
        answer.insert(0, "4");
      } else {
        answer.insert(0, num % 3);
        num /= 3;
      }
    }

    return answer.toString();
  }
}
