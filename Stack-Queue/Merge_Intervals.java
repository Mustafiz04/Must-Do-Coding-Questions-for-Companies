class Solution {
  class Pair {
    int start, end;

    Pair(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    int n = intervals.length;
    Stack<int[]> st = new Stack<>();

    for (int i = 0; i < n; i++) {
      if (st.isEmpty() || st.peek()[1] < intervals[i][0]) {
        st.push(intervals[i]);
      } else {
        st.peek()[1] = Math.max(st.peek()[1], intervals[i][1]);
      }
    }

    return st.toArray(new int[st.size()][]);

    // LinkedList<int[]> ans = new LinkedList<>();
    // for(int i = 0; i<n; i++){
    // if( ans.isEmpty() || ans.getLast()[1] < intervals[i][0] ){
    // ans.add(intervals[i]);
    // }else{
    // ans.getLast()[1] = Math.max(ans.getLast()[1], intervals[i][1]);
    // }
    // }
    // return ans.toArray(new int[ans.size()][]);
  }
}