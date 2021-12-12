import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;

class Driverclass {
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {

      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
      }
      System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
    }
  }
}


class Solution {
  static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
    if (arr == null || n == 0) {
      return 0;
    }
    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] == 0 ? -1 : arr[i];
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int currSum = 0, count = 0;
    ;

    for (int i = 0; i < n; i++) {
      currSum += arr[i];
      if (map.containsKey(currSum)) {
        count += map.get(currSum);
      }
      map.put(currSum, map.getOrDefault(currSum, 0) + 1);
    }
    return count;
  }
}
