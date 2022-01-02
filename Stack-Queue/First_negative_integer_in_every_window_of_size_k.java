// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      long a[] = new long[(int) (n)];
      // long getAnswer[] = new long[(int)(n)];
      String inputLine[] = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        a[i] = Long.parseLong(inputLine[i]);
      }
      int k = Integer.parseInt(br.readLine().trim());

      Compute obj = new Compute();
      long answer[] = obj.printFirstNegativeInteger(a, n, k);
      int sz = answer.length;

      StringBuilder output = new StringBuilder();
      for (int i = 0; i < sz; i++)
        output.append(answer[i] + " ");
      System.out.println(output);

    }
  }
}

class Compute {
  public long[] printFirstNegativeInteger(long A[], int N, int K) {
    long[] ans = new long[N + 1 - K];
    int index = 0;
    Deque<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < K; i++) {
      if (A[i] < 0) {
        q.addLast(i);
      }
    }

    for (int i = K; i < N; i++) {
      ans[index++] = q.isEmpty() ? 0 : A[q.peek()];

      while (!q.isEmpty() && q.peek() <= i - K) {
        q.removeFirst();
      }

      if (A[i] < 0) {
        q.addLast(i);
      }
    }

    ans[index++] = q.isEmpty() ? 0 : A[q.peek()];
    return ans;
  }
}