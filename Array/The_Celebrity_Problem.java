// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int N = sc.nextInt();
      int M[][] = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          M[i][j] = sc.nextInt();
        }
      }
      System.out.println(new Solution().celebrity(M, N));
      t--;
    }
  }
} 

class Solution {
  int celebrity(int M[][], int n) {
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < n; i++) {
      stack.push(i);
    }

    while (stack.size() != 1) {
      int a = stack.pop();
      int b = stack.pop();
      if (M[a][b] == 1) {
        stack.push(b);
      } else {
        stack.push(a);
      }
    }
    int c = stack.pop();
    for (int i = 0; i < n; i++) {
      if (i != c && (M[i][c] != 1 || M[c][i] == 1)) {
        return -1;
      }
    }
    return c;

  }
}