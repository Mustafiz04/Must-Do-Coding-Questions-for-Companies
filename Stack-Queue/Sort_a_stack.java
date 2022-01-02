
// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      Stack<Integer> s = new Stack<>();
      int n = sc.nextInt();
      while (n-- > 0)
        s.push(sc.nextInt());
      GfG g = new GfG();
      Stack<Integer> a = g.sort(s);
      while (!a.empty()) {
        System.out.print(a.peek() + " ");
        a.pop();
      }
      System.out.println();
    }
  }
}


class GfG {
  public Stack<Integer> sort(Stack<Integer> s) {
    if (s == null || s.isEmpty()) {
      return s;
    } else {
      int x = s.pop();
      sort(s);
      insertAtBottom(s, x);
    }

    // Stack<Integer> st = new Stack<Integer>();

    // while( !s.isEmpty() ){
    // int top = s.pop();
    // while( !st.isEmpty() && top < st.peek() ){
    // s.push(st.pop());
    // }
    // st.push(top);
    // }
    return s;
  }

  public void insertAtBottom(Stack<Integer> s, int x) {
    if (s.isEmpty() || x > s.peek()) {
      s.push(x);
    } else {
      int a = s.pop();
      insertAtBottom(s, x);

      s.push(a);
    }
  }
}