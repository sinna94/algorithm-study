package study.programmers.level2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tuple {
    public int[] solution(String s) {
        Pattern pattern = Pattern.compile("\\{\\d+(,\\d+)*}");
        Matcher matcher = pattern.matcher(s.substring(1, s.length() - 1));
        ArrayList<String[]> elementList = new ArrayList<>();
        while (matcher.find()) {
            String group = matcher.group();
            elementList.add(matcher.group().substring(1, group.length() - 1).split(","));
        }
        elementList.sort(Comparator.comparingInt(list -> list.length));
        HashSet<String> elementSet = new LinkedHashSet<>();
        for (String[] elements : elementList) {
            elementSet.addAll(Arrays.asList(elements));
        }

        return elementSet.stream().mapToInt(Integer::parseInt).toArray();
    }
}
