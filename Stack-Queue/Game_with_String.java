// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      String s = in.readLine();
      int k = Integer.parseInt(in.readLine());

      Solution ob = new Solution();
      System.out.println(ob.minValue(s, k));
    }
  }
}

class Solution {
  static int minValue(String s, int k) {
    int n = s.length();
    if (n == 0)
      return 0;
    int[] arr = new int[26];
    for (char c : s.toCharArray()) {
      arr[c - 'a']++;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : arr) {
      if (num != 0)
        pq.add(num);
    }
    while (!pq.isEmpty() && k > 0) {
      int freq = pq.poll();
      pq.add(--freq);
      k--;
    }
    int sum = 0;
    while (!pq.isEmpty()) {
      int freq = pq.poll();
      sum += (int) Math.pow(freq, 2);
    }
    return sum;
  }
}