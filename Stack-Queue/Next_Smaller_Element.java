import java.util.*;
import java.io.*;

public class Solution {
  static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    if (n == 0)
      return null;
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (s.isEmpty())
        s.push(i);
      while (!s.isEmpty() && arr.get(s.peek()) > arr.get(i)) {
        ans[s.pop()] = arr.get(i);
      }
      s.push(i);
    }
    ArrayList<Integer> al = new ArrayList<>();
    for (int i : ans)
      al.add(i);
    return al;
  }
}