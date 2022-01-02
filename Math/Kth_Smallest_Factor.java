import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String S[] = read.readLine().split(" ");

      int N = Integer.parseInt(S[0]);
      int K = Integer.parseInt(S[1]);

      Solution ob = new Solution();
      System.out.println(ob.kThSmallestFactor(N, K));
    }
  }
}

class Solution {
  static int kThSmallestFactor(int N, int K) {
    int c = 0, sq = (int) Math.sqrt(N);
    for (int i = 1; i <= sq; i++) {
      if (N % i == 0)
        c++;
      if (K == c)
        return i;
    }
    c *= 2;
    if (sq * sq == N)
      c--;
    if (K > c)
      return -1;
    c = 1 + c - K;
    for (int i = 1; i * i <= N; i++) {
      if (N % i == 0)
        c--;
      if (c == 0)
        return N / i;
    }
    return -1;

    // if( K == 1 ) return 1;
    // ArrayList<Integer> factors = new ArrayList<>();
    // for(int i = 1; i<=Math.sqrt(N); i++ ){
    // if( N % i == 0 ) factors.add(i);
    // }
    // int n = factors.size()-1;
    // for(int i = n; i>=0; i-- ){
    // if( factors.get(i) == Math.sqrt(N) ) {
    // continue;
    // }else{
    // factors.add( N / factors.get(i) );
    // }
    // }
    // if( factors.size() < K ) return -1;
    // return factors.get(K-1);
  }
};