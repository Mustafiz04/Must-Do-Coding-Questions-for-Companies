// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String[] args) {

    // taking input using Scanner class
    Scanner sc = new Scanner(System.in);

    // taking total testcases
    int t = sc.nextInt();

    sc.nextLine();
    while (t-- > 0) {
      // taking String X and Y
      String S[] = sc.nextLine().split(" ");
      String X = S[0];
      String Y = S[1];

      // calling function shortestCommonSupersequence()
      System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
    }
  }
}

class Solution {
  public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
    return m + n - LCS(X, Y, m, n);
  }

  public static int LCS(String s, String t, int n, int m) {
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return dp[n][m];
  }
}