package study.programmers.level2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CandidateKey {
    public int solution(String[][] relation) {
        int columnCount = relation[0].length;

        Set<Set<Integer>> candidates = new HashSet<>();
        for (int i = 0; i < columnCount; i++) {
            dfs(candidates, relation, columnCount, Set.of(i), i);
        }

        var resultSet = new HashSet<Set<Integer>>();

        candidates
            .stream()
            .sorted(Comparator.comparingInt(Set::size))
            .forEach(c -> {
                if (resultSet.stream().noneMatch(c::containsAll)) {
                    resultSet.add(c);
                }
            });

        return resultSet.size();
    }

    private void dfs(Set<Set<Integer>> candidates, String[][] relation, int columnCount, Set<Integer> columnNums, int columnIndex) {
        Set<String> keySet = new HashSet<>();

        for (String[] columns : relation) {
            StringBuilder key = new StringBuilder();
            columnNums.forEach(columnNum -> key.append(columns[columnNum]));
            keySet.add(key.toString());
        }

        if (!keySet.isEmpty() && keySet.size() == relation.length) {
            candidates.add(columnNums);
            return;
        }

        if (columnCount == columnNums.size()) {
            return;
        }

        for (int i = columnIndex; i < columnCount; i++) {
            if (!columnNums.contains(i)) {
                HashSet<Integer> newColumnNums = new HashSet<>(columnNums);
                newColumnNums.add(i);
                dfs(candidates, relation, columnCount, newColumnNums, i);
            }
        }
    }
}
