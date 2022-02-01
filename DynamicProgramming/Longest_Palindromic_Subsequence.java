// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s = sc.next();
      Solution obj = new Solution();
      System.out.println(obj.longestPalinSubseq(s));
    }

  }
}

class Solution {
  public int longestPalinSubseq(String S) {
    int n = S.length();
    String T = reverse(S);
    int[][] dp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[n][n];
  }

  public String reverse(String s) {
    char[] arr = s.toCharArray();
    int l = 0, r = arr.length - 1;
    while (l <= r) {
      char temp = arr[l];
      arr[l] = arr[r];
      arr[r] = temp;
      l++;
      r--;
    }
    String ans = "";
    for (char c : arr)
      ans += c;
    return ans;
  }
}