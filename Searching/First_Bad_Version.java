import java.util.*;

public class First_Bad_Version {
  public static void main(String[] args) {

  }

  public int firstBadVersion(int n) {
    int l = 1, r = n;
    int ans = -1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (isBadVersion(mid) == true) {
        ans = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return ans;
  }
}
