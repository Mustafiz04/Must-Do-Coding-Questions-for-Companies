
// { Driver Code Starts
import java.util.Scanner;

class SquartRoot {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      long a = sc.nextInt();
      Solution obj = new Solution();
      System.out.println(obj.floorSqrt(a));
      t--;
    }
  }
}

class Solution {
  long floorSqrt(long x) {
    if (x == 1)
      return 1;
    long l = 1, r = x;
    long ans = -1;
    while (l <= r) {
      long mid = l + (r - l) / 2;
      if (mid * mid == x)
        return mid;
      if (mid * mid < x) {
        ans = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return ans;
  }
}
