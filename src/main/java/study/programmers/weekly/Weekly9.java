package study.programmers.weekly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Weekly9 {
    public int solution(int n, int[][] wires) {

        boolean[][] towerArr = createTowerArr(n, wires);

        Optional<Integer> returnOpt = Arrays.stream(wires)
            .map(wire -> dividePowerWire(wire, n, towerArr))
            .min(Comparator.comparingInt(count -> count));

        if (returnOpt.isEmpty()) {
            return 0;
        }

        return returnOpt.get();
    }

    private int dividePowerWire(int[] wire, int n, boolean[][] towerArr) {
        boolean[] visited = new boolean[n];
        int t1 = wire[0] - 1;
        int t2 = wire[1] - 1;

        towerArr[t1][t2] = false;
        towerArr[t2][t1] = false;

        int onSideTowerCount = dfs(towerArr, 0, visited);

        towerArr[t1][t2] = true;
        towerArr[t2][t1] = true;
        return Math.abs(n - (2 * onSideTowerCount));
    }

    private boolean[][] createTowerArr(int n, int[][] wires) {
        boolean[][] towerArr = new boolean[n][n];

        for (int[] wire : wires) {
            int t1 = wire[0] - 1;
            int t2 = wire[1] - 1;
            towerArr[t1][t2] = true;
            towerArr[t2][t1] = true;
        }
        return towerArr;
    }

    private int dfs(boolean[][] towerArr, int tower, boolean[] visited) {
        visited[tower] = true;
        int towerCount = 1;

        for (int i = 0; i < towerArr.length; i++) {
            if (!visited[i] && towerArr[tower][i]) {
                towerCount += dfs(towerArr, i, visited);
            }
        }
        return towerCount;
    }
}
