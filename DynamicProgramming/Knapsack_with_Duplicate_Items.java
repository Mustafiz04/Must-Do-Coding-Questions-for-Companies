// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      String line1[] = in.readLine().trim().split("\\s+");
      int N = Integer.parseInt(line1[0]);
      int W = Integer.parseInt(line1[1]);
      String line2[] = in.readLine().trim().split("\\s+");
      int val[] = new int[N];
      for (int i = 0; i < N; i++)
        val[i] = Integer.parseInt(line2[i]);
      String line3[] = in.readLine().trim().split("\\s+");
      int wt[] = new int[N];
      for (int i = 0; i < N; i++)
        wt[i] = Integer.parseInt(line3[i]);

      Solution ob = new Solution();
      System.out.println(ob.knapSack(N, W, val, wt));
    }
  }
}

class Solution {
  static int knapSack(int n, int w, int val[], int wt[]) {
    int[][] dp = new int[n + 1][w + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= w; j++) {
        if (wt[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - wt[i - 1]] + val[i - 1]);
        }
      }
    }
    return dp[n][w];
  }
}