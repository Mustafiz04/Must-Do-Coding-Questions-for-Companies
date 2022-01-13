class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < (n - 1 - i); j++) {
        // Clock wise
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = temp;

        // Anticlock wise
        // int temp = arr[i][j];
        // arr[i][j] = arr[j][n - i - 1];
        // arr[j][n - i - 1] = arr[n - 1 - i][n - 1 - j];
        // arr[n - 1 - i][n - 1 - j] = arr[n - j - 1][i];
        // arr[n - j - 1][i] = temp;
      }
    }
  }
}