class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    int col = matrix[0].length;

    int bottom = row - 1, left = 0;
    while (bottom >= 0 && left < col) {
      int val = matrix[bottom][left];
      if (val == target) {
        return true;
      } else if (val > target) {
        bottom--;
      } else {
        left++;
      }
    }
    return false;
  }
}