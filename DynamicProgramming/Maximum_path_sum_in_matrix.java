import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(in.readLine());
      String input_line[] = in.readLine().trim().split("\\s+");
      int Matrix[][] = new int[N][N];
      for (int i = 0; i < N * N; i++)
        Matrix[(i / N)][i % N] = Integer.parseInt(input_line[i]);

      Solution ob = new Solution();
      System.out.println(ob.maximumPath(N, Matrix));
    }
  }
}

class Solution {
  static int maximumPath(int N, int Matrix[][]) {
    int maxValue = -1;
    for (int i = 0; i < N; i++) {
      maxValue = Math.max(maxValue, Matrix[0][i]);
    }
    for (int i = 1; i < N; i++) {
      maxValue = -1;
      for (int j = 0; j < N; j++) {
        if (j > 0 && j < N - 1) {
          Matrix[i][j] += Math.max(Matrix[i - 1][j], Math.max(Matrix[i - 1][j - 1], Matrix[i - 1][j + 1]));
        } else if (j > 0) {
          Matrix[i][j] += Math.max(Matrix[i - 1][j], Matrix[i - 1][j - 1]);
        } else if (j < N - 1) {
          Matrix[i][j] += Math.max(Matrix[i - 1][j], Matrix[i - 1][j + 1]);
        }
        maxValue = Math.max(Matrix[i][j], maxValue);
      }
    }
    return maxValue;
  }
}