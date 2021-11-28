package Array;
import java.util.*;

public class Single_Number {
  public static void main(String[] args) {

  }

  public int singleNumber(int[] nums) {
    if (nums.length == 0)
      return 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i : nums) {
      hm.put(i, hm.getOrDefault(i, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> map : hm.entrySet()) {
      if (map.getValue() == 1) {
        return map.getKey();
      }
    }
    return -1;
  }
}
