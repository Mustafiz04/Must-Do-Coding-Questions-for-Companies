import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int test = sc.nextInt();
    while (test-- > 0) {
      int p = sc.nextInt(); // Take size of both the strings as input
      int q = sc.nextInt();

      String s1 = sc.next(); // Take both the string as input
      String s2 = sc.next();

      Solution obj = new Solution();

      System.out.println(obj.lcs(p, q, s1, s2));
    }
  }
}

class Solution {
  static int lcs(int x, int y, String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();

    int[][] dp = new int[x + 1][y + 1];

    for (int i = 0; i <= x; i++) {
      for (int j = 0; j <= y; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (a[i - 1] == b[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    return dp[x][y];

    // return lcs(a, b, x, y);
  }

  static int lcs(char[] a, char[] b, int m, int n) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if (a[m - 1] == b[n - 1]) {
      return 1 + lcs(a, b, m - 1, n - 1);
    } else {
      return Math.max(lcs(a, b, m - 1, n), lcs(a, b, m, n - 1));
    }
  }

}