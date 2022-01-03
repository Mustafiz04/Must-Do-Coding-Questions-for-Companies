
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
      int ans = obj.orangesRotting(grid);
      System.out.println(ans);
    }
  }
}

class Solution {
  // Function to find minimum time required to rot all oranges.
  class Node {
    int time, x, y;

    Node(int time, int x, int y) {
      this.time = time;
      this.x = x;
      this.y = y;
    }
  }

  public int orangesRotting(int[][] grid) {
    int row = grid.length;
    if (row == 0)
      return -1;
    int col = grid[0].length;
    int freshOrange = 0;
    Queue<Node> q = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 2) {
          q.add(new Node(0, i, j));
        } else if (grid[i][j] == 1) {
          freshOrange++;
        }
      }
    }
    int time = 0;

    int[] px = { -1, 0, 1, 0 };
    int[] py = { 0, 1, 0, -1 };
    while (!q.isEmpty()) {
      Node curr = q.poll();
      int cx = curr.x;
      int cy = curr.y;
      time = curr.time;
      for (int i = 0; i < 4; i++) {
        int x = cx + px[i];
        int y = cy + py[i];
        if (validPos(x, y, row, col) && grid[x][y] == 1) {
          freshOrange--;
          grid[x][y] = 2;
          q.add(new Node(curr.time + 1, x, y));
        }
      }
    }

    if (freshOrange != 0) {
      return -1;
    }
    return time;
  }

  public boolean validPos(int x, int y, int n, int m) {
    return (x >= 0 && x < n && y >= 0 && y < m);
  }
}