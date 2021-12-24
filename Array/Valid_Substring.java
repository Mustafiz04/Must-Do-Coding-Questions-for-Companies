
// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String S = read.readLine();

      Solution ob = new Solution();
      System.out.println(ob.findMaxLen(S));
    }
  }
}

// User function Template for Java
class Solution {
  static int findMaxLen(String S) {
    int n = S.length();
    if (S == null || n == 0) {
      return 0;
    }
    Stack<Integer> st = new Stack<>();
    st.push(-1);
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      char curr = S.charAt(i);
      if (curr == '(') {
        st.push(i);
      } else {
        st.pop();
        if (st.isEmpty()) {
          st.push(i);
        }
        maxLen = Math.max(maxLen, i - st.peek());
      }
    }
    return maxLen;
    // int n = S.length();
    // HashMap<Integer, Integer> map = new HashMap<>();
    // int maxLen = 0;
    // int sum = 0;
    // for(int i = 0; i<n; i++){
    // sum += S.charAt(i) == '(' ? 1 : -1;

    // if( sum == 0 && maxLen == 0 ){
    // maxLen = 1;
    // }
    // if( sum == 0 ) maxLen = i+1;

    // if( map.containsKey(sum) ){
    // int prevIndex = map.get(sum);
    // maxLen = Math.max(maxLen, i - prevIndex );
    // }else{
    // map.put(sum, i);
    // }
    // }
    // return maxLen;
  }
};