
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] S1 = br.readLine().trim().split(" ");
      int n = Integer.parseInt(S1[0]);
      int m = Integer.parseInt(S1[1]);
      int[][] image = new int[n][m];
      for (int i = 0; i < n; i++) {
        String[] S2 = br.readLine().trim().split(" ");
        for (int j = 0; j < m; j++)
          image[i][j] = Integer.parseInt(S2[j]);
      }
      String[] S3 = br.readLine().trim().split(" ");
      int sr = Integer.parseInt(S3[0]);
      int sc = Integer.parseInt(S3[1]);
      int newColor = Integer.parseInt(S3[2]);
      Solution obj = new Solution();
      int[][] ans = obj.floodFill(image, sr, sc, newColor);
      for (int i = 0; i < ans.length; i++) {
        for (int j = 0; j < ans[i].length; j++)
          System.out.print(ans[i][j] + " ");
        System.out.println();
      }
    }
  }
}


class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int row = image.length;
    if (row == 0)
      return image;
    int col = image[0].length;
    int currColor = image[sr][sc];
    if (currColor != newColor) {
      dfs(image, sr, sc, row, col, newColor, currColor);
    }

    return image;
  }

  public void dfs(int[][] image, int sr, int sc, int row, int col, int newColor, int currColor) {
    if (sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != currColor) {
      return;
    }
    image[sr][sc] = newColor;
    dfs(image, sr + 1, sc, row, col, newColor, currColor);
    dfs(image, sr - 1, sc, row, col, newColor, currColor);
    dfs(image, sr, sc + 1, row, col, newColor, currColor);
    dfs(image, sr, sc - 1, row, col, newColor, currColor);
  }
}