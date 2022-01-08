// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

  // Driver code
  public static void main(String[] args) throws IOException {
    // Taking input using buffered reader
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testcases = Integer.parseInt(br.readLine());

    // looping through all testcases
    while (testcases-- > 0) {
      String line = br.readLine();
      String[] element = line.trim().split("\\s+");
      int sizeOfArray = Integer.parseInt(element[0]);
      int K = Integer.parseInt(element[1]);
      int arr[] = new int[sizeOfArray];

      line = br.readLine();
      String[] elements = line.trim().split("\\s+");
      for (int i = 0; i < sizeOfArray; i++) {
        arr[i] = Integer.parseInt(elements[i]);
      }
      int X = Integer.parseInt(br.readLine());

      Complete obj = new Complete();
      int ans = obj.search(arr, sizeOfArray, X, K);
      System.out.println(ans);
    }
  }

class Complete {
  public static int search(int arr[], int n, int x, int k) {
    int i = 0;
    while (i < n) {
      if (arr[i] == x)
        return i;
      i += Math.max(1, Math.abs(arr[i] - x) / k);
    }
    return -1;
  }
}
