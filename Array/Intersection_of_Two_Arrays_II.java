package Array;

import java.util.*;

public class Intersection_of_Two_Arrays_II {
  public static void main(String[] args) {

  }

  public int[] intersect(int[] nums1, int[] nums2) {
    ArrayList<Integer> ans = new ArrayList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int n1 = nums1.length;
    int n2 = nums2.length;
    int i = 0, j = 0;
    while (i < n1 && j < n2) {
      if (nums1[i] == nums2[j]) {
        ans.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }
    int[] arr = new int[ans.size()];
    for (int z = 0; z < ans.size(); z++) {
      arr[z] = ans.get(z);
    }
    return arr;
  }
}
