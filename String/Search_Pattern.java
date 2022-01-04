// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s, patt;
      s = sc.next();
      patt = sc.next();

      Solution ob = new Solution();

      ArrayList<Integer> res = ob.search(patt, s);

      if (res.size() == 0)
        System.out.print("-1 ");
      else {
        for (int i = 0; i < res.size(); i++)
          System.out.print(res.get(i) + " ");
      }
      System.out.println();
    }
  }
}

class Solution {
  ArrayList<Integer> search(String pat, String S) {
    ArrayList<Integer> ans = new ArrayList<>();
    int i = 0;
    while (i < S.length()) {
      while (i < S.length() && S.charAt(i) != pat.charAt(0))
        i++;
      int j = 0, k = i;
      while (k < S.length() && j < pat.length() && S.charAt(k) == pat.charAt(j)) {
        k++;
        j++;
      }
      if (j == pat.length() && k <= S.length())
        ans.add(i + 1);
      i++;
    }
    return ans;
  }
}