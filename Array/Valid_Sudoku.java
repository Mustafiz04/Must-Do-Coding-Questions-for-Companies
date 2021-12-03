package Array;

public class Valid_Sudoku {
  public static void main(String[] args) {

  }

  public boolean isValidSudoku(char[][] board) {
    return isValidSudoku(board, 9);
  }

  public boolean isValidSudoku(char[][] board, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        char val = board[i][j];
        if (val != '.') {
          if (!safe(board, i, j, val)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public boolean safe(char[][] board, int row, int col, char val) {
    for (int r = 0; r < 9; r++) {
      if (r == row) {
        continue;
      } else if (board[r][col] == val) {
        return false;
      }
    }
    for (int c = 0; c < 9; c++) {
      if (c == col) {
        continue;
      } else if (board[row][c] == val) {
        return false;
      }
    }
    int sqrt = (int) Math.sqrt(9);
    int rs = row - row % sqrt;
    int cs = col - col % sqrt;

    for (int i = rs; i < rs + sqrt; i++) {
      for (int j = cs; j < cs + sqrt; j++) {
        if (i == row && j == col) {
          continue;
        } else if (board[i][j] == val) {
          return false;
        }
      }
    }
    return true;
  }
}
