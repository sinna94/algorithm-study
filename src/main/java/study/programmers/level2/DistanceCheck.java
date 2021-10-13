package study.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceCheck {

    public static final int PLACE_SIZE = 5;
    public static final char PERSON = 'P';
    public static final char TABLE = 'O';

    static class Point {
        int x;
        int y;

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
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[PLACE_SIZE];

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            boolean[][] visited = new boolean[PLACE_SIZE][PLACE_SIZE];
            queue.clear();
            answer[i] = checkDistance(queue, place, visited) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkDistance(Queue<Point> queue, String[] place, boolean[][] visited) {
        for (int y = 0; y < PLACE_SIZE; y++) {
            for (int x = 0; x < PLACE_SIZE; x++) {
                if (place[y].charAt(x) == PERSON) {
                    boolean check = bfs(place, queue, visited, y, x);
                    if (!check) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void addPoints(Queue<Point> queue, boolean[][] visited, int y, int x) {
        if (y > 0 && !visited[y - 1][x]) {
            queue.add(new Point(x, y - 1));
            visited[y - 1][x] = true;
        }
        if (y < PLACE_SIZE - 1 && !visited[y + 1][x]) {
            queue.add(new Point(x, y + 1));
            visited[y + 1][x] = true;
        }
        if (x > 0 && !visited[y][x - 1]) {
            queue.add(new Point(x - 1, y));
            visited[y][x - 1] = true;
        }
        if (x < PLACE_SIZE - 1 && !visited[y][x + 1]) {
            queue.add(new Point(x + 1, y));
            visited[y][x + 1] = true;
        }
    }

    private boolean bfs(String[] place, Queue<Point> queue, boolean[][] visited, int y, int x) {
        addPoints(queue, visited, y, x);
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int pointY = point.getY();
            int pointX = point.getX();

            int manhattanDistance = getManhattanDistance(y, x, pointY, pointX);
            if (manhattanDistance > 2) {
                continue;
            }

            char status = place[pointY].charAt(pointX);
            if (status == PERSON) {
                return false;
            }
            if (status == TABLE) {
                addPoints(queue, visited, pointY, pointX);
            }
        }
        return true;
    }

    private int getManhattanDistance(int y, int x, int pointY, int pointX) {
        return Math.abs(x - pointX) + Math.abs(y - pointY);
    }
}
