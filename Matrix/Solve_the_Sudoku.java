// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class {
  public static void main(String args[]) {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int grid[][] = new int[9][9];
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++)
          grid[i][j] = sc.nextInt();
      }

      Solution ob = new Solution();

      if (ob.SolveSudoku(grid) == true)
        ob.printGrid(grid);
      else
        System.out.print("NO solution exists");
      System.out.println();

    }
  }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
  static boolean SolveSudoku(int grid[][]) {
    int row = -1, col = -1;
    boolean isEmpty = false;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (grid[i][j] == 0) {
          row = i;
          col = j;
          isEmpty = true;
          break;
        }
      }
      if (isEmpty)
        break;
    }
    if (!isEmpty)
      return true;

    for (int i = 1; i <= 9; i++) {
      if (isSafe(grid, row, col, i)) {
        grid[row][col] = i;
        if (SolveSudoku(grid)) {
          return true;
        } else {
          grid[row][col] = 0;
        }
      }
    }
    return false;
  }

  static boolean isSafe(int[][] grid, int row, int col, int num) {
    for (int i = 0; i < 9; i++) {
      if (grid[row][i] == num)
        return false;
    }

    for (int i = 0; i < 9; i++) {
      if (grid[i][col] == num)
        return false;
    }

    int sqrt = (int) Math.sqrt(9);
    int rowStart = row - row % sqrt;
    int colStart = col - col % sqrt;
    for (int i = rowStart; i < rowStart + sqrt; i++) {
      for (int j = colStart; j < colStart + sqrt; j++) {
        if (grid[i][j] == num) {
          return false;
        }
      }
    }
    return true;

  }

  static void printGrid(int grid[][]) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(grid[i][j] + " ");
      }
    }
  }
}