
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      long n = Long.parseLong(br.readLine().trim());
      String inputLine[] = br.readLine().trim().split(" ");
      long[] arr = new long[(int) n];
      for (int i = 0; i < n; i++)
        arr[i] = Long.parseLong(inputLine[i]);
      System.out.println(new Solution().getMaxArea(arr, n));
    }
  }
}

// } Driver Code Ends

class Solution {
  public static long getMaxArea(long hist[], long n) {
    if (n == 0)
      return (long) 0;
    long[] leftLimit = new long[(int) n];
    long[] rightLimit = new long[(int) n];
    Stack<Integer> s = new Stack<>();
    s.push(0);
    leftLimit[0] = 0;
    for (int i = 0; i < n; i++) {
      while (!s.isEmpty() && hist[s.peek()] >= hist[i]) {
        s.pop();
      }
      leftLimit[i] = s.isEmpty() ? 0 : s.peek() + 1;
      s.push(i);
    }
    s.clear();
    s.push((int) n - 1);
    rightLimit[(int) n - 1] = n - 1;
    for (int i = (int) n - 2; i >= 0; i--) {
      while (!s.isEmpty() && hist[s.peek()] >= hist[i]) {
        s.pop();
      }
      rightLimit[i] = s.isEmpty() ? n - 1 : s.peek() - 1;
      s.push(i);
    }

    long maxArea = 0;
    for (int i = 0; i < n; i++) {
      long area = hist[i] * (rightLimit[i] - leftLimit[i] + 1);
      maxArea = Math.max(maxArea, area);
    }
    return maxArea;
  }

}
