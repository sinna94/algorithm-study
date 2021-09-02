package study.programmers.weekly;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/84512
 * 2021-09-02
 */

public class Weekly5 {
  public int solution(String word) {
    // I = 1563
    // 781 = 5*5*5*5 + 5*5*5 + 5*5 + 5 + 1
    // total = 3905
    // XXXXX = XXXX + (A = 0, E = 1, I = 2, O = 3, U = 4) + 1
    // XXXX = XXX + (A = 0, E = 1, I = 2, O = 3, U = 4) * 6 + 1
    // XXX = XX + (A = 0, E = 1, I = 2, O = 3, U = 4) * 31 + 1
    // XX = X + (A = 0, E = 1, I = 2, O = 3, U = 4) * 156 + 1
    // X = X (A = 0, E = 1, I = 2, O = 3, U = 4) * 781 + 1

    int answer = 0;
    int index = 0;
    int [] indexValue = {781, 156, 31, 6, 1};

    for (int i = 0; i < word.length(); i++) {
      int num = convertWordToNum(word.charAt(i));
      answer += indexValue[index] * num + 1;
      index += 1;
    }

    return answer;
  }

  public int convertWordToNum(char word) {
    if (word == 'A')
      return 0;
    else if (word == 'E')
      return 1;
    else if (word == 'I')
      return 2;
    else if (word == 'O')
      return 3;
    else if (word == 'U')
      return 4;
    else
      return -1;
  }
}
