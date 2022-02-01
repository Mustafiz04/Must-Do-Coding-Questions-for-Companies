
// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());

    while (t-- > 0) {
      int n = Integer.parseInt(read.readLine());
      String str = read.readLine().strip();
      Solution ob = new Solution();
      long ans = ob.minDeletions(str, n);
      System.out.println(ans);
    }
  }
} 


class Solution {
  int minDeletions(String str, int n) {
    int len = longestPalinSubseq(str);
    return n - len;
  }

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