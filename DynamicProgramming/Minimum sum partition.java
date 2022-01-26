// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int A[] = new int[n];
      for (int i = 0; i < n; i++)
        A[i] = sc.nextInt();
      Solution ob = new Solution();
      System.out.println(ob.minDifference(A, n));
    }
  }
} 

class Solution {
  int minDiff = Integer.MAX_VALUE;

  public int minDifference(int arr[], int n) {
    // minDifference(arr, n, 0, 0);
    // return minDiff;
    int sum = 0;
    for (int i : arr)
      sum += i;
    Boolean[][] dp = new Boolean[n + 1][sum + 1];
    for (int i = 0; i <= sum; i++)
      dp[0][i] = false;
    for (int i = 0; i <= n; i++)
      dp[i][0] = true;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
        }
      }
    }

    for (int i = 0; i <= sum / 2; i++) {
      if (dp[n][i] && minDiff > Math.abs(i - (sum - i))) {
        minDiff = Math.abs(i - (sum - i));
      }
    }

    return minDiff;

  }

  public void minDifference(int[] arr, int n, int sum1, int sum2) {
    if (n == 0) {
      minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
      return;
    }
    minDifference(arr, n - 1, sum1 + arr[n - 1], sum2);
    minDifference(arr, n - 1, sum1, sum2 + arr[n - 1]);
  }
}
