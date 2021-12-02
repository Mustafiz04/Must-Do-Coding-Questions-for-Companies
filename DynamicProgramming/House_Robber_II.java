package DynamicProgramming;

public class House_Robber_II {
  public static void main(String[] args) {

  }

  public int rob(int[] nums) {
    int n = nums.length;
    if (nums == null || n == 0)
      return 0;
    if (n == 1)
      return nums[0];
    int startZero = maxMoney(nums, 0, n - 2, n);
    int startOne = maxMoney(nums, 1, n - 1, n);

    return Math.max(startZero, startOne);
  }

  public int maxMoney(int[] arr, int start, int end, int n) {
    if (start == end)
      return arr[start];
    int[] dp = new int[n];
    dp[start] = arr[start];
    dp[start + 1] = Math.max(dp[start], arr[start + 1]);

    for (int i = start + 2; i <= end; i++) {
      dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
    }
    return dp[end];
  }
}
