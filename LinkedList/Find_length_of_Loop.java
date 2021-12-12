import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

class GFG {
  public static void makeLoop(Node head, Node tail, int x) {
    if (x == 0)
      return;

    Node curr = head;
    for (int i = 1; i < x; i++)
      curr = curr.next;

    tail.next = curr;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();

      int num = sc.nextInt();
      Node head = new Node(num);
      Node tail = head;

      for (int i = 0; i < n - 1; i++) {
        num = sc.nextInt();
        tail.next = new Node(num);
        tail = tail.next;
      }

      int pos = sc.nextInt();
      makeLoop(head, tail, pos);

      Solution x = new Solution();
      System.out.println(x.countNodesinLoop(head));
    }
  }
}

class Solution {
  static int countNodesinLoop(Node head) {
    Node slow = head, fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        int count = 1;
        slow = slow.next;
        while (slow != fast) {
          slow = slow.next;
          count++;
        }
        return count;
      }
    }

    return 0;
  }
}