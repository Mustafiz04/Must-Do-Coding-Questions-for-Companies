import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(read.readLine());
      String input_line[] = read.readLine().trim().split("\\s+");
      int Arr[] = new int[N];
      for (int i = 0; i < N; i++)
        Arr[i] = Integer.parseInt(input_line[i]);
      int k = Integer.parseInt(read.readLine());

      Solution ob = new Solution();
      System.out.println(ob.findSubArraySum(Arr, N, k));
    }
  }
}

class Solution {
  static int findSubArraySum(int Arr[], int N, int k) {
    int total = 0;
    int currSum = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < N; i++) {
      currSum += Arr[i];

      if (currSum == k) {
        total++;
      }

      if (hm.containsKey(currSum - k)) {
        total += hm.get(currSum - k);
      }

      Integer count = hm.get(currSum);
      if (count == null) {
        hm.put(currSum, 1);
      } else {
        hm.put(currSum, count + 1);
      }
    }
    return total;
  }
}