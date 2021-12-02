package DynamicProgramming;

public class Jump_Game {
  public static void main(String[] args) {

  }

  public boolean canJump(int[] nums) {
    int n = nums.length;
    // int[] dp = new int[n];
    // if( n == 1 ) return true;
    // dp[0] = nums[0];
    // for(int i = 1; i<n; i++){
    // if( dp[i-1] < i ) return false;

    // dp[i] = Math.max(dp[i-1], nums[i] + i);
    // if( dp[i-1] >= n-1 ) return true;
    // }
    // return dp[n-2] >= n-1 ? true : false;
    int reachable = 0;
    for (int i = 0; i < n; i++) {
      if (reachable < i)
        return false;
      reachable = Math.max(reachable, nums[i] + i);
    }
    return true;
  }
}
