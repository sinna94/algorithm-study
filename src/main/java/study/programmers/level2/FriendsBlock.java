package study.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;

public class FriendsBlock {
    private static final char REMOVED_BLOCK = '0';
    private static final char EMPTY_BLOCK = 0;

    public int solution(int m, int n, String[] board) {

        char[][] charBoard = createCharBoard(m, n, board);
        int answer = 0;
        int removeCount;
        while ((removeCount = removeBlock(m, n, charBoard)) > 0) {
            answer += removeCount;
            dropBlock(m, n, charBoard);
        }

        return answer;
    }

    private void dropBlock(int m, int n, char[][] charBoard) {
        for (int rowCount = 0; rowCount < m; rowCount++) {
            for (int i = m - 1; i > rowCount; i--) {
                for (int j = 0; j < n; j++) {
                    if (charBoard[i][j] == REMOVED_BLOCK || charBoard[i][j] == EMPTY_BLOCK) {
                        charBoard[i][j] = charBoard[i - 1][j];
                        charBoard[i - 1][j] = EMPTY_BLOCK;
                    }
                }
            }
        }
    }

    private char[][] createCharBoard(int m, int n, String[] board) {
        char[][] charBoard = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            charBoard[i] = board[i].toCharArray();
        }
        return charBoard;
    }

    private int removeBlock(int m, int n, char[][] board) {
        HashSet<Cell> removeCells = new HashSet<>();
        char[][] removedBoard = new char[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char block = board[i][j];

                if (block == REMOVED_BLOCK || block == EMPTY_BLOCK) {
                    continue;
                }

                if (board[i + 1][j] == block && board[i][j + 1] == block && board[i + 1][j + 1] == block) {
                    addRemovedCell(removeCells, removedBoard, i, j);
                    addRemovedCell(removeCells, removedBoard, i + 1, j);
                    addRemovedCell(removeCells, removedBoard, i, j + 1);
                    addRemovedCell(removeCells, removedBoard, i + 1, j + 1);
                } else {
                    copyCell(board, removedBoard, i, j);
                    copyCell(board, removedBoard, i + 1, j);
                    copyCell(board, removedBoard, i, j + 1);
                    copyCell(board, removedBoard, i + 1, j + 1);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            board[i] = Arrays.copyOf(removedBoard[i], n);
        }

        return removeCells.size();
    }

    private void addRemovedCell(HashSet<Cell> removeCells, char[][] removedBoard, int i, int j) {
        removedBoard[i][j] = REMOVED_BLOCK;
        removeCells.add(new Cell(i, j));
    }

    private void copyCell(char[][] board, char[][] removedBoard, int i, int j) {
        if (removedBoard[i][j] != REMOVED_BLOCK) {
            removedBoard[i][j] = board[i][j];
        }
    }
}

class Cell {
    private final int row;
    private final int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (row != cell.row) return false;
        return col == cell.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }
}
