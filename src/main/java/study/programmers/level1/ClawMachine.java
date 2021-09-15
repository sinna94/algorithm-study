package study.programmers.level1;

import java.util.LinkedList;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
 * 2021-09-15
 */

public class ClawMachine {
  public int solution(int[][] board, int[] moves) {
    LinkedList<Integer> dollQueue = new LinkedList<>();
    int removeCount = 0;
    for (int move : moves) {
      int colIndex = move - 1;

      int rowIndex = 0;

      for (int i = 0; i < board.length; i++) {
        if(board[rowIndex][colIndex] != 0){
          break;
        }
        rowIndex++;
      }

      if (rowIndex < board.length) {
        int doll = board[rowIndex][colIndex];
        if (dollQueue.peek() != null && dollQueue.peek() == doll) {
          dollQueue.pop();
          removeCount += 2;
        } else {
          dollQueue.push(doll);
        }
        board[rowIndex][colIndex] = 0;
      }
    }
    return removeCount;
  }
}
