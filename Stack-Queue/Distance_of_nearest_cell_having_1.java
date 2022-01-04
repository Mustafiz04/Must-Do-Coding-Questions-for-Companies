
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int n = Integer.parseInt(s[0]);
      int m = Integer.parseInt(s[1]);
      int[][] grid = new int[n][m];
      for (int i = 0; i < n; i++) {
        String[] S = br.readLine().trim().split(" ");
        for (int j = 0; j < m; j++) {
          grid[i][j] = Integer.parseInt(S[j]);
        }
      }
      Solution obj = new Solution();
      int[][] ans = obj.nearest(grid);
      for (int i = 0; i < ans.length; i++) {
        for (int j = 0; j < ans[i].length; j++) {
          System.out.print(ans[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}

class Solution {
  class Pair {
    int x, y;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int[][] nearest(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int[][] dis = new int[row][col];
    for (int i = 0; i < row; i++)
      Arrays.fill(dis[i], Integer.MAX_VALUE);
    Queue<Pair> q = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          dis[i][j] = 0;
          q.add(new Pair(i, j));
        }
      }
    }
    int[] xDir = { 0, 1, 0, -1 };
    int[] yDir = { 1, 0, -1, 0 };
    while (!q.isEmpty()) {
      Pair curr = q.poll();
      int currX = curr.x;
      int currY = curr.y;
      for (int i = 0; i < 4; i++) {
        int x = curr.x + xDir[i];
        int y = curr.y + yDir[i];

        if (x >= 0 && x < row && y >= 0 && y < col) {
          if (dis[x][y] > dis[currX][currY] + 1) {
            dis[x][y] = dis[currX][currY] + 1;
            q.add(new Pair(x, y));
          }
        }
      }
    }
    return dis;
  }
}