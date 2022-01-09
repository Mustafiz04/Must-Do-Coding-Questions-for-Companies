class Solution {
  public int maximalSquare(char[][] matrix) {
    int row = matrix.length;
    if (row == 0)
      return 0;
    int col = matrix[0].length;
    int[][] dp = new int[row + 1][col + 1];
    for (int i = 0; i < row; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i < col; i++) {
      dp[0][i] = 0;
    }

    int maxLen = Integer.MIN_VALUE;
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        if (matrix[i - 1][j - 1] == '0') {
          dp[i][j] = 0;
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
        }
        maxLen = Math.max(maxLen, dp[i][j]);
      }
    }

    return maxLen * maxLen;
  }
}