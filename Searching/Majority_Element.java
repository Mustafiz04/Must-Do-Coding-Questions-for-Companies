// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];

      for (int i = 0; i < n; i++)
        arr[i] = sc.nextInt();

      System.out.println(new Solution().majorityElement(arr, n));
    }
  }
}

class Solution {
  static int majorityElement(int arr[], int n) {
    if (n == 1)
      return arr[0];
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      if (hm.containsKey(arr[i])) {
        int val = hm.get(arr[i]) + 1;
        if (val > n / 2) {
          return arr[i];
        } else {
          hm.put(arr[i], val);
        }
      } else {
        hm.put(arr[i], 1);
      }
    }
    return -1;
  }

  // public static int findMajority(int[] arr, int n) {
  //   int majority = 0, count = 1;
  //   for (int i = 1; i < n; i++) {
  //     if (arr[i] == arr[majority]) {
  //       count++;
  //     } else {
  //       count--;
  //     }
  //     if (count == 0) {
  //       count = 1;
  //       majority = i;
  //     }
  //   }
  //   return isMajority(arr, n, arr[majority]) ? arr[majority] : -1;
  // }

  // public static boolean isMajority(int[] arr, int n, int majority) {
  //   int count = 0;
  //   for (int i = 0; i < n; i++) {
  //     if (arr[i] == majority) {
  //       count++;
  //     }
  //   }
  //   return count > n / 2 ? true : false;
  // }
}