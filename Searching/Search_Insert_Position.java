import java.util.*;

public class Search_Insert_Position {
  public static void main(String[] args) {

  }

  public int searchInsert(int[] nums, int target) {
    int n = nums.length;
    int start = binary(nums, n, target);
    if (start == n) {
      int end = binary(nums, n, target + 1);
      return end;
    }
    return start;
  }

  public int binary(int[] nums, int n, int k) {
    int l = 0;
    int r = n - 1;
    int p = n;

    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] >= k) {
        p = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return p;
  }
}
