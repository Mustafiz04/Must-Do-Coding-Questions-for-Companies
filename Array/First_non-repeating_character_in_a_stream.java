package Array;

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String A = br.readLine().trim();
      Solution ob = new Solution();
      String ans = ob.FirstNonRepeating(A);
      System.out.println(ans);
    }
  }
}

class Solution {
  public String FirstNonRepeating(String stream) {
    StringBuilder ret = new StringBuilder();
    int isRepeated[] = new int[26];
    Deque<Character> queue = new ArrayDeque<>();
    for (int i = 0; i < stream.length(); i++) {
      char ch = stream.charAt(i);
      if (isRepeated[ch - 'a'] == 0) {
        queue.add(ch);
      }

      isRepeated[ch - 'a']++;
      while (!queue.isEmpty() && isRepeated[queue.peek() - 'a'] != 1) {
        queue.poll();
      }
      ret.append(queue.isEmpty() ? '#' : queue.peek());

    }
    return ret.toString();
  }
}