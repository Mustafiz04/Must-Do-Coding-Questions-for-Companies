package DynamicProgramming;

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      String read[] = in.readLine().trim().split("\\s+");
      int n = Integer.parseInt(read[0]);
      int r = Integer.parseInt(read[1]);

      Solution ob = new Solution();
      System.out.println(ob.nCr(n, r));
    }
  }
}

class Solution {
  static int nCr(int n, int r) {
    // Recursive
    // if (r > n)
    // return 0;
    // if (k == 0 || r == n)
    // return 1;

    // return nCr(n - 1, r - 1) + nCr(n - 1, r);

    int[][] dp = new int[n + 1][r + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= Math.min(i, r); j++) {
        if (j == 0 || j == i) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        }
      }
    }
    return dp[n][r];
  }
}
