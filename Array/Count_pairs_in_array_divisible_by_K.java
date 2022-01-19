
// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
    while (t-- > 0) {

      int n = Integer.parseInt(br.readLine().trim());
      String inputLine[] = br.readLine().trim().split(" ");
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }

      int k = Integer.parseInt(br.readLine().trim());

      Solution ob = new Solution();
      System.out.println(ob.countKdivPairs(arr, n, k));
    }
  }
}

class Solution {
  public static int countKdivPairs(int arr[], int n, int k) {
    int[] rem = new int[k + 1];
    if (n == 0)
      return 0;
    int count = 0;
    for (int num : arr) {
      if (num % k == 0) {
        count += rem[0];
      } else {
        count += rem[k - num % k];
      }
      rem[num % k]++;
    }
    return count;
  }
}