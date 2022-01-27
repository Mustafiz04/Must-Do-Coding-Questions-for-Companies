
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(read.readLine());
      String input_line[] = read.readLine().trim().split("\\s+");
      int arr[] = new int[N];
      for (int i = 0; i < N; i++)
        arr[i] = Integer.parseInt(input_line[i]);
      int sum = Integer.parseInt(read.readLine());

      Solution ob = new Solution();
      if (ob.isSubsetSum(N, arr, sum))
        System.out.println(1);
      else
        System.out.println(0);

    }
  }
}

class Solution {
  static Boolean isSubsetSum(int n, int arr[], int sum) {
    Boolean[][] dp = new Boolean[n + 1][sum + 1];
    for (int i = 0; i <= sum; i++) {
      dp[0][i] = false;
    }

    for (int i = 0; i <= n; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
        }
      }
    }

    return dp[n][sum];
  }
}