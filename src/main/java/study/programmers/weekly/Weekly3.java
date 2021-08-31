package study.programmers.weekly;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/84021?language=java
 * 2021-08-31
 */

public class Weekly3 {

  private static class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public boolean isAdjacent(int x, int y) {

      if (x < 0) {
        return false;
      }

      if (y < 0) {
        return false;
      }

      if (this.x - x == 1 && this.y == y) {
        return true;
      }
      if (this.x - x == -1 && this.y == y) {
        return true;
      }
      if (this.x == x && this.y - y == 1) {
        return true;
      }

      return this.x == x && this.y - y == -1;
    }
  }

  public int solution(int[][] game_board, int[][] table) {

    ArrayList<Set<Point>> emptyBoards = new ArrayList<>();
    ArrayList<Set<Point>> blocks = new ArrayList<>();

    for (int i = 0; i < game_board.length; i++) {
      for (int j = 0; j < game_board.length; j++) {
        int cell = game_board[i][j];
        int blockCell = table[i][j];

        if (cell == 0) {
          calculateAdjacentPoint(emptyBoards, i, j);
        }
        if (blockCell == 1) {
          calculateAdjacentPoint(blocks, i, j);
        }
      }
    }

    Map<String, Long> boardMap = emptyBoards.stream()
      .map(this::createBlockArrayString)
      .collect(
        Collectors.groupingBy(
          Function.identity(), Collectors.counting()
        )
      );

    int answer = 0;
    for (Set<Point> block : blocks) {
      int[][] blockArray = createBlockArray(block);
      int[][] rotateArray = blockArray.clone();
      for (int i = 0; i < 4; i++) {

        int[][] sortedArray = sortArray(rotateArray);

        String blockArrayString = Arrays.deepToString(sortedArray);
        if (boardMap.containsKey(blockArrayString)) {
          Long board = boardMap.get(blockArrayString);
          if (board > 0) {
            boardMap.put(blockArrayString, board - 1);
            answer += blockArrayString.chars().filter(c -> c == '1').count();
            break;
          }
        }
        rotateArray = rotate(rotateArray);
      }
    }

    return answer;
  }

  /**
   * 배열을 좌상단으로 정렬
   * @param rotateArray
   * @return
   */
  private int[][] sortArray(int[][] rotateArray) {
    int valueRow = -1;
    int valueCol = -1;

    for (int r = 0; r < rotateArray.length; r++) {
      if (valueRow == -1 && Arrays.stream(rotateArray[r]).sum() != 0) {
        valueRow = r;
      }
      int colSum = 0;
      if (valueCol == -1) {
        for (int[] col : rotateArray) {
          colSum += col[r];
        }
        if (colSum != 0) {
          valueCol = r;
        }
      }
    }

    if(valueRow == -1){
      valueRow = 0;
    }

    if(valueCol == -1){
      valueCol = 0;
    }


    int[][] sortedArray = new int[rotateArray.length][rotateArray.length];
    for (int i = valueRow; i < rotateArray.length; i++) {
      for (int j = valueCol; j < rotateArray.length; j++) {
        sortedArray[i - valueRow][j - valueCol] = rotateArray[i][j];
      }
    }
    return sortedArray;
  }

  /**
   * 배열을 시계방향으로 90도 회전
   * @param array
   * @return
   */
  private int[][] rotate(int[][] array) {
    int size = array.length;
    int[][] rotateArray = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = size - 1; j >= 0; j--) {
        rotateArray[j][size - 1 - i] = array[i][j];
      }
    }
    return rotateArray;
  }

  private String createBlockArrayString(Set<Point> block) {
    int[][] blockArray = createBlockArray(block);
    return Arrays.deepToString(blockArray);
  }

  /**
   * 좌표를 기준으로 배열 생성
   * @param block
   * @return
   */
  @NotNull
  private int[][] createBlockArray(Set<Point> block) {
    int minX = block.stream().min(Comparator.comparingInt(Point::getX)).get().getX();
    int minY = block.stream().min(Comparator.comparingInt(Point::getY)).get().getY();
    int maxX = block.stream().max(Comparator.comparingInt(Point::getX)).get().getX();
    int maxY = block.stream().max(Comparator.comparingInt(Point::getY)).get().getY();

    int size = Math.max((maxX - minX), (maxY - minY)) + 1;

    int[][] blockArray = new int[size][size];
    for (Point point : block) {
      int x = point.getX();
      int y = point.getY();

      blockArray[y - minY][x - minX] = 1;
    }
    return blockArray;
  }

  /**
   * 저장된 좌표 중 근접한 좌표가 있는지 계산
   * 근접한 좌표가 여러개라면 하나로 합침
   * @param emptyBoards
   * @param i
   * @param j
   */
  private void calculateAdjacentPoint(ArrayList<Set<Point>> emptyBoards, int i, int j) {
    ArrayList<Integer> adjacentPointIndexList = new ArrayList<>();

    if (emptyBoards.size() == 0) {
      HashSet<Point> pointSet = new HashSet<>();
      pointSet.add(new Point(j, i));
      emptyBoards.add(pointSet);
    } else {
      for (int k = 0; k < emptyBoards.size(); k++) {
        Set<Point> pointSet = emptyBoards.get(k);
        for (Point point : pointSet) {
          if (point.isAdjacent(j, i)) {
            adjacentPointIndexList.add(k);
            break;
          }
        }
      }
      if (adjacentPointIndexList.size() > 0) {
        Set<Point> parentSet = emptyBoards.get(adjacentPointIndexList.get(0));
        for (Integer pointIndex : adjacentPointIndexList) {
          Set<Point> pointSet = emptyBoards.get(pointIndex);
          parentSet.addAll(pointSet);
        }
        emptyBoards.removeAll(adjacentPointIndexList.subList(1, adjacentPointIndexList.size()).stream().map(emptyBoards::get).collect(Collectors.toList()));
        parentSet.add(new Point(j, i));
      } else {
        HashSet<Point> newPointSet = new HashSet<>();
        newPointSet.add(new Point(j, i));
        emptyBoards.add(newPointSet);
      }
    }
  }
}
