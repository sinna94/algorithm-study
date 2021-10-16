package study.programmers.level2;

import java.util.ArrayList;

public class LightPathCycle {

    private static final char L = 'L';
    private static final char R = 'R';
    private static final int[] directionRow = {-1, 0, 1, 0};
    private static final int[] directionCol = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        boolean[][][] isVisited = new boolean[grid.length][grid[0].length()][4];
        ArrayList<Integer> resultList = new ArrayList<>();


        for (int i = 0; i < grid.length; i++) {
            String row = grid[i];
            for (int j = 0; j < row.length(); j++) {
                isVisited[i][j] = new boolean[]{false, false, false, false};
            }
        }

        findCycle(grid, isVisited, resultList);

        return resultList.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private void findCycle(String[] grid, boolean[][][] isVisited, ArrayList<Integer> resultList) {
        for (int row = 0; row < isVisited.length; row++) {
            for (int col = 0; col < isVisited[row].length; col++) {
                for (int direction = 0; direction < isVisited[row][col].length; direction++) {
                    if (!isVisited[row][col][direction]) {
                        resultList.add(moveLight(grid, row, col, direction, isVisited));
                    }
                }
            }
        }
    }

    private int moveLight(String[] grid, int row, int col, int direction, boolean[][][] isVisited) {
        int cycleLength = 0;

        while (true) {
            if (isVisited[row][col][direction]) {
                return cycleLength;
            }

            isVisited[row][col][direction] = true;
            cycleLength += 1;
            char rotateValue = grid[row].charAt(col);
            direction = rotateDirection(direction, rotateValue);
            row = rotateRow(grid, row, direction);
            col = rotateCol(grid, col, direction);
        }
    }

    private int rotateCol(String[] grid, int col, int direction) {
        col += directionCol[direction];
        int colLength = grid[0].length();
        if (col < 0) {
            col = colLength - 1;
        }
        if (col >= colLength) {
            col = 0;
        }
        return col;
    }

    private int rotateRow(String[] grid, int row, int direction) {
        row += directionRow[direction];
        int rowLength = grid.length;
        if (row < 0) {
            row = rowLength - 1;
        }
        if (row >= rowLength) {
            row = 0;
        }
        return row;
    }

    private int rotateDirection(int direction, char rotateValue) {
        if (rotateValue == L) {
            direction = direction > 0 ? direction - 1 : 3;
        } else if (rotateValue == R) {
            direction = direction < 3 ? direction + 1 : 0;
        }
        return direction;
    }
}
