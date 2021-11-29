import java.util.*;
import java.io.*;

class GFG {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      int array[] = new int[n];
      for (int i = 0; i < n; ++i) {
        array[i] = sc.nextInt();
      }

      Solution ob = new Solution();

      int ans[] = ob.help_classmate(array, n);

      for (int i = 0; i < n; i++)
        System.out.print(ans[i] + " ");
      System.out.println();
      t--;
    }
  }
}

class Solution {
  public static int[] help_classmate(int arr[], int n) {
    int[] ans = new int[n];
    // O(n)
    Arrays.fill(ans, -1);
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
        ans[st.pop()] = arr[i];
      }
      st.push(i);
    }
    return ans;

    // O(n2)
    // for(int i = 0; i<n; i++){
    // int curr = arr[i];
    // for(int j = i+1; j<n; j++){
    // if( arr[j] < curr ){
    // ans[i] = arr[j];
    // break;
    // }
    // }
    // }
    // return ans;
  }
}
