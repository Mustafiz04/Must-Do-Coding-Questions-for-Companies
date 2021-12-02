
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      int array[] = new int[n];
      for (int i = 0; i < n; ++i) {
        array[i] = sc.nextInt();
      }

      Solution ob = new Solution();
      System.out.println(ob.longestSubsequence(n, array));
      t--;
    }
  }
}

class Solution {
  static int longestSubsequence(int size, int a[]) {
    int[] dp = new int[size];
    Arrays.fill(dp, 1);
    int max = 0;
    for (int i = 1; i < size; i++) {
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}