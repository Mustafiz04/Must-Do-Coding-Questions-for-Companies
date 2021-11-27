// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String s = br.readLine().trim();
      String[] S1 = s.split(" ");
      int n = Integer.parseInt(S1[0]);
      int m = Integer.parseInt(S1[1]);
      Solution ob = new Solution();
      int ans = ob.NthRoot(n, m);
      System.out.println(ans);
    }
  }
}

class Solution {
  public int NthRoot(int n, int m) {
    int low = 1, high = m;
    while (low <= high) {
      int mid = (low + high) / 2;
      int nthPow = (int) Math.pow(mid, n);
      if (nthPow == m) {
        return mid;
      } else if (nthPow > m) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }
}