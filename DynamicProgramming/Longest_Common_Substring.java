// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String input[] = read.readLine().trim().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);

      String S1 = read.readLine().trim();
      String S2 = read.readLine().trim();

      Solution ob = new Solution();
      System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
    }
  }
}

class Solution {
  int maxLen = 0, currLen = 0;

  int longestCommonSubstr(String S1, String S2, int n, int m) {
    // return LCS(S1, S2, n, m, 0);

    int[][] dp = new int[n + 1][m + 1];
    int max = 0;

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0 || S1.charAt(i - 1) != S2.charAt(j - 1)) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          max = Math.max(dp[i][j], max);
        }
      }
    }
    return max;
  }

  int LCS(String s, String t, int n, int m, int count) {
    if (n == 0 || m == 0)
      return 0;

    if (s.charAt(n - 1) == t.charAt(m - 1)) {
      count = LCS(s, t, n - 1, m - 1, count + 1);
    }
    return Math.max(count, Math.max(LCS(s, t, n - 1, m, 0), LCS(s, t, n, m - 1, 0)));
  }
}