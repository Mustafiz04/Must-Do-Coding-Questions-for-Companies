import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      String[] inputLine = br.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }

      System.out.println(new Solution().maxProduct(arr, n));
    }
  }
}

class Solution {
  long maxProduct(int[] arr, int n) {
    long maxSoFar = arr[0];
    long minSoFar = arr[0];
    long ans = maxSoFar;

    for (int i = 1; i < n; i++) {
      long curr = arr[i];
      long tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
      minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
      maxSoFar = tempMax;
      ans = Math.max(ans, maxSoFar);
    }
    return ans;
  }
}