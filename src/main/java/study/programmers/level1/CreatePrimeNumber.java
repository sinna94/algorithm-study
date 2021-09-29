package study.programmers.level1;

public class CreatePrimeNumber {
  public int solution(int[] nums) {
    int answer = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (isPrime(nums[i] + nums[j] + nums[k])) {
            answer += 1;
          }
        }
      }
    }

    return answer;
  }

  private boolean isPrime(int num) {
    if (num <= 1)
      return false;
    if (num == 2)
      return true;

    if ((num % 2) == 0)
      return false;

    var i = 3;

    while (i * i <= num) {
      if (num % i == 0)
        return false;
      i++;
    }
    return true;
  }
}
