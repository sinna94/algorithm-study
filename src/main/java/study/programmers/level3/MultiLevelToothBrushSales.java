package study.programmers.level3;

import java.util.Arrays;
import java.util.HashMap;

public class MultiLevelToothBrushSales {
  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    HashMap<String, Seller> sellerHashMap = new HashMap<>();

    for (int i = 0; i < enroll.length; i++) {
      String referralName = referral[i];
      Seller referralSeller = sellerHashMap.get(referralName);
      Seller sellerObj = Seller.createSeller(referralName, referralSeller);
      String name = enroll[i];
      sellerHashMap.put(name, sellerObj);
    }

    for (int i = 0; i < seller.length; i++) {
      String sellerName = seller[i];
      int sellAmount = amount[i] * 100;

      Seller sellerObj = sellerHashMap.get(sellerName);
      sellerObj.addAmount(sellAmount);
    }

    return Arrays.stream(enroll).mapToInt(name -> {
      Seller sellerObj = sellerHashMap.get(name);
      return sellerObj.getAmount();
    }).toArray();
  }
}

class Seller {
  private Seller referral;
  private int amount = 0;

  public static Seller createSeller(String referralName, Seller referral){
    if(referralName.equals("-")){
      return new Seller();
    }

    return new Seller(referral);
  }

  // not exist referral
  private Seller() {
  }

  private Seller(Seller referral) {
    this.referral = referral;
  }

  public void addAmount(int amount) {
    int distribution = calDistribution(amount);
    distribute(distribution);
    this.amount += amount - distribution;
  }

  private void distribute(int distribution) {
    if (referral != null) {
      this.referral.addAmount(distribution);
    }
  }

  private int calDistribution(int amount) {
    return Math.floorDiv(amount, 10);
  }

  public int getAmount() {
    return amount;
  }
}
