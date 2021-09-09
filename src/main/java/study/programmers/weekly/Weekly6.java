package study.programmers.weekly;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/85002
 * 2021-09-08
 */

public class Weekly6 {

  public int[] solution(int[] weights, String[] head2head) {
    ArrayList<Boxer> boxers = new ArrayList<>();

    for (int i = 0; i < weights.length; i++) {
      Boxer boxer = new Boxer(i + 1, weights[i]);
      boxer.fight(weights, head2head[i]);
      boxers.add(boxer);
    }


    return boxers.stream().sorted().mapToInt(Boxer::getNum).toArray();
  }
}

class Boxer implements Comparable<Boxer> {
  private final int num;
  private final int weight;
  private int overWeightWinCount = 0;
  private Double average = 0.0;

  public Boxer(int num, int weight) {
    this.num = num;
    this.weight = weight;
  }

  public void fight(int[] otherWeights, String results) {
    int winCount = 0;
    int playCount = 0;
    for (int i = 0; i < otherWeights.length; i++) {
      if ((i + 1) != num) {
        char result = results.charAt(i);
        if (result == 'W') {
          winCount += 1;
          playCount += 1;
          if (otherWeights[i] > weight) {
            overWeightWinCount += 1;
          }
        }
        if(result == 'L'){
          playCount += 1;
        }
      }
    }

    if (winCount != 0) {
      average = ((double) winCount) / playCount;
    }
  }

  public int getNum() {
    return num;
  }

  public int getWeight() {
    return weight;
  }

  public int getOverWeightWinCount() {
    return overWeightWinCount;
  }

  public Double getAverage() {
    return average;
  }

  @Override
  public int compareTo(@NotNull Boxer o) {
    return compareAverage(this, o);
  }

  private int compareAverage(Boxer b1, Boxer b2) {
    if (b1.getAverage().equals(b2.getAverage())) {
      return compareOverWeightWinCount(b1, b2);
    }
    return b2.getAverage().compareTo(b1.getAverage());
  }

  private int compareOverWeightWinCount(Boxer b1, Boxer b2) {
    if (b1.getOverWeightWinCount() == b2.getOverWeightWinCount()) {
      return compareWeight(b1, b2);
    }
    return b2.getOverWeightWinCount() - b1.getOverWeightWinCount();
  }

  private int compareWeight(Boxer b1, Boxer b2) {
    if (b1.getWeight() == b2.getWeight()) {
      return compareNum(b1, b2);
    }
    return b2.getWeight() - b1.getWeight();
  }

  private int compareNum(Boxer b1, Boxer b2) {
    return b1.getNum() - b2.getNum();
  }
}
