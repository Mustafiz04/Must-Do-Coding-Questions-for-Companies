
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String s1 = br.readLine();
      String[] S = s1.split(" ");
      String s = S[0];
      String t = S[1];
      Solution ob = new Solution();
      int ans = ob.editDistance(s, t);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends

class Solution {
  public int editDistance(String s, String t) {
    int a = s.length();
    int b = t.length();
    char[] arr1 = s.toCharArray();
    char[] arr2 = t.toCharArray();

    int[][] dp = new int[a + 1][b + 1];
    for (int i = 0; i <= a; i++) {
      for (int j = 0; j <= b; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else if (arr1[i - 1] == arr2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
        }
      }
    }
    return dp[a][b];

    // Recursive
    // return ed(arr1, arr2, a, b);
  }

  // Recursive
  public int ed(char[] arr1, char[] arr2, int a, int b) {
    if (a == 0)
      return b;
    if (b == 0)
      return a;

    if (arr1[a - 1] == arr2[b - 1]) {
      return ed(arr1, arr2, a - 1, b - 1);
    } else {
      return 1 + Math.min(ed(arr1, arr2, a - 1, b), Math.min(ed(arr1, arr2, a, b - 1), ed(arr1, arr2, a - 1, b - 1)));
    }
  }
}