
// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s1 = sc.next();
      String s2 = sc.next();
      Solution ob = new Solution();
      System.out.println(ob.minOperations(s1, s2));
    }
  }
} 

class Solution {
  public int minOperations(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();
    return n + m - 2 * LCS(str1, str2, n, m);
  }

  public int LCS(String s, String t, int n, int m) {
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][m];
  }
}