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
                System.out.println(prices[i] + ":" + prices[j]);
                if (prices[i] > prices[j]) {
                    time = j - i;
                    System.out.print(j);
                    break;
                }
            }
            answer[i] = time;
            System.out.println("time:" + time);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = new StockPrice().solution(new int[] { 1, 2, 3, 2, 3 });
        System.out.println(result);
    }
}
