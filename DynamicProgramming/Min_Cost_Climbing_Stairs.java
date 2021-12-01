package DynamicProgramming;

import java.util.*;

class Solution {
  public static void main(String[] args) {

  }

  public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int[] minCost = new int[n + 1];
    minCost[n - 1] = cost[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      minCost[i] = Math.min(minCost[i + 1], minCost[i + 2]) + cost[i];
    }
    return Math.min(minCost[0], minCost[1]);
  }
}