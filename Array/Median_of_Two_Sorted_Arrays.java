public class Median_of_Two_Sorted_Arrays {
  public static void main(String[] args) {

  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int i = 0, j = 0, m1 = -1, m2 = -1;
    if ((n + m) % 2 == 1) {
      for (int count = 0; count <= (n + m) / 2; count++) {
        if (i != n && j != m) {
          m1 = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
        } else if (i != n) {
          m1 = nums1[i++];
        } else {
          m1 = nums2[j++];
        }
      }
      return (double) m1;
    } else {
      for (int count = 0; count <= (n + m) / 2; count++) {
        m2 = m1;
        if (i != n && j != m) {
          m1 = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
        } else if (i != n) {
          m1 = nums1[i++];
        } else {
          m1 = nums2[j++];
        }
      }
      return (double) (m1 + m2) / 2;
    }
  }
}
