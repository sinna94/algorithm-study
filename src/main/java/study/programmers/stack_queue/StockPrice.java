package study.programmers.stack_queue;
/*
 * 2020-07-30
 * https://programmers.co.kr/learn/courses/30/lessons/42584?language=java
 */

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int time = prices.length - 1 - i;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    time = j - i;
                    break;
                }
            }
            answer[i] = time;
        }

        return answer;
    }
}
