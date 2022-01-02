import java.util.Stack;

public class Solution {
  public static void reverseStack(Stack<Integer> stack) {
    if (!stack.isEmpty()) {
      int x = stack.pop();
      reverseStack(stack);

      insertAtBottom(stack, x);
    }
  }

  public static void insertAtBottom(Stack<Integer> s, int x) {
    if (s.isEmpty()) {
      s.push(x);
    } else {
      int a = s.pop();
      insertAtBottom(s, x);

      s.push(a);
    }
  }
}
