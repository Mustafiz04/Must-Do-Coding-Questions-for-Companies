package Array;

public class Reshape_the_Matrix {
  public static void main(String[] args) {

  }

  public int[][] matrixReshape(int[][] mat, int r, int c) {
    int row = mat.length;
    int col = mat[0].length;
    if (row * col != r * c)
      return mat;

    int[][] ans = new int[r][c];
    int newR = 0, newC = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        ans[newR][newC++] = mat[i][j];
        if (newC == c) {
          newR++;
          newC = 0;
        }
      }
    }
    return ans;
  }
}
