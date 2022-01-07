// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
  // Driver code
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      String[] str = br.readLine().split(" ");

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(str[i]);
      }

      int[] ans = new Solve().findTwoElement(a, n);
      System.out.println(ans[0] + " " + ans[1]);
    }
  }
}

class Solve {
  int[] findTwoElement(int arr[], int n) {
    int missing = -1, repeating = -1;
    for (int i = 0; i < n; i++) {
      if (arr[Math.abs(arr[i]) - 1] < 0) {
        repeating = Math.abs(arr[i]);
      } else {
        arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
      }
    }
    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        missing = i + 1;
      }
    }

    return new int[] { repeating, missing };

    // int[] freq = new int[n+1];
    // for(int num : arr){
    // freq[num]++;
    // }
    // int missing = -1, repeating = -1;
    // for(int i = 1; i<=n; i++){
    // if(freq[i] == 0) missing = i;
    // if( freq[i] == 2 ) repeating = i;
    // }

    // return new int[]{repeating, missing};
  }
}