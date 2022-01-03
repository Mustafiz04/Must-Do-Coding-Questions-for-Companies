
// { Driver Code Starts
import java.util.*;
import java.util.Stack;
import java.util.LinkedList;

class GfG {
  public static void main(String args[]) {
    // Taking input using class Scanner
    Scanner sc = new Scanner(System.in);

    // Taking input the number of testcases
    int t = sc.nextInt();
    while (t > 0) {
      // Creating a new object of class StackQueue
      StackQueue g = new StackQueue();

      // Taking input the total number of Queries
      int q = sc.nextInt();
      while (q > 0) {
        int QueryTyoe = sc.nextInt();

        // If QueryTyoe is 1 then
        // we call the Push method
        // of class StackQueue
        // else we call the Pop method
        if (QueryTyoe == 1) {
          int a = sc.nextInt();
          g.Push(a);
        } else if (QueryTyoe == 2)
          System.out.print(g.Pop() + " ");
        q--;

      }
      System.out.println();
      t--;
    }
  }
}

class StackQueue {
  Stack<Integer> s1 = new Stack<Integer>();
  Stack<Integer> s2 = new Stack<Integer>();

  // Function to push an element in queue by using 2 stacks.
  void Push(int x) {
    s1.push(x);
  }

  int Pop() {
    if (!s2.isEmpty()) {
      return s2.pop();
    } else {
      if (s1.isEmpty())
        return -1;
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
      return s2.pop();
    }
  }
}
