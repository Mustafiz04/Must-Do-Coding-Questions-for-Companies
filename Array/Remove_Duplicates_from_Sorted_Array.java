package Array;

public class Remove_Duplicates_from_Sorted_Array {
  public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;
    int length = 1;
    int curr = nums[0];
    for (int i = 1; i < n; i++) {
      if (nums[i] != curr) {
        nums[length++] = nums[i];
        curr = nums[i];
      }
    }
    return length;
  }

  public static void main(String[] args) {

  }
}
