
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
    StringBuilder res = new StringBuilder();
    int[] isRepeated = new int[26];
    Queue<Character> q = new LinkedList<>();
    for (int i = 0; i < stream.length(); i++) {
      char ch = stream.charAt(i);
      if (isRepeated[ch - 'a'] == 0) {
        q.add(ch);
      }
      isRepeated[ch - 'a']++;
      while (!q.isEmpty() && isRepeated[q.peek() - 'a'] != 1) {
        q.poll();
      }
      res.append(q.isEmpty() ? '#' : q.peek());
    }
    return res.toString();
  }
}