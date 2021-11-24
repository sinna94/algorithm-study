package study.programmers.level2;

import java.util.*;

public class CacheSolution {
    public int solution(int cacheSize, String[] cities) {
        Cache cache = new Cache(cacheSize);
        return Arrays.stream(cities).mapToInt(cache::add).sum();
    }
}

class Cache {
    private final int cacheSize;
    private final Queue<String> lruQueue = new LinkedList<>();

    public Cache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public int add(String city) {

        if (cacheSize == 0) {
            return 5;
        }

        String lowerCaseCity = city.toLowerCase();

        if (lruQueue.contains(lowerCaseCity)) {
            lruQueue.remove(lowerCaseCity);
            lruQueue.add(lowerCaseCity);
            return 1;
        }

        if (lruQueue.size() >= cacheSize) {
            lruQueue.poll();
        }
        lruQueue.add(lowerCaseCity);

        return 5;
    }
}
