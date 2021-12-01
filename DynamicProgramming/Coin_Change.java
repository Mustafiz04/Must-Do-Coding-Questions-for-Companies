package DynamicProgramming;

import java.io.*;
import java.util.*;

class GfG {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int Arr[] = new int[m];
      for (int i = 0; i < m; i++)
        Arr[i] = sc.nextInt();
      Solution ob = new Solution();
      System.out.println(ob.count(Arr, m, n));
    }
  }
}

class Solution {
  public long count(int S[], int m, int n) {
    long[][] mat = new long[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      mat[i][0] = 1;
    }
    for (int i = 1; i <= n; i++) {
      mat[0][i] = 0;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (S[i - 1] <= j) {
          mat[i][j] = mat[i - 1][j] + mat[i][j - S[i - 1]];
        } else {
          mat[i][j] = mat[i - 1][j];
        }
      }
    }
    return mat[m][n];

    // if( n == 0 ){
    // return 1;
    // }

    // if( n < 0 ){
    // return 0;
    // }

    // if( m <= 0 && n >= 1 ){
    // return 0;
    // }

    // return count( S, m-1, n ) + count(S, m, n - S[m-1] );
  }
}

// n = 4
// m = {1,2,3}


