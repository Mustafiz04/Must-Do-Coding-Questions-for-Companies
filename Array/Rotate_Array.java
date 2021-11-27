package Array;

public class Rotate_Array {
  public void rotate(int[] nums, int d) {
    int n = nums.length;
    d = d % n;
    d = n - d;
    int gcd = gcd(n, d);
    int i, j, k, temp;
    for (i = 0; i < gcd; i++) {
      temp = nums[i];
      j = i;
      while (true) {
        k = j + d;
        if (k >= n) {
          k = k - n;
        }
        if (k == i) {
          break;
        }
        nums[j] = nums[k];
        j = k;
      }
      nums[j] = temp;
    }
  }

  public int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }

  public static void main(String[] args) {

  }
}
