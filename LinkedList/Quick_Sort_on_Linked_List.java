
// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

class SortLL {
  static Node head;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      addToTheLast(head);

      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        addToTheLast(new Node(a));
      }

      GfG gfg = new GfG();
      Node node = gfg.quickSort(head);

      printList(node);
      System.out.println();
    }
  }

  public static void printList(Node head) {
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  public static void addToTheLast(Node node) {
    if (head == null) {
      head = node;
    } else {
      Node temp = head;
      while (temp.next != null)
        temp = temp.next;
      temp.next = node;
    }
  }
}

class GfG {
  static Node partition(Node head, Node tail) {
    Node prev = head, cur = head.next;
    Node pivot = head;
    int data = 0;
    while (cur != tail.next) {
      if (cur.data < pivot.data) {
        data = prev.next.data;
        prev.next.data = cur.data;
        cur.data = data;
        prev = prev.next;
      }
      cur = cur.next;
    }
    data = pivot.data;
    pivot.data = prev.data;
    prev.data = data;
    return prev;
  }

  static void quickSortrec(Node head, Node tail) {
    if (head == tail || tail == null || head == null)
      return;

    Node pivot = partition(head, tail);
    quickSortrec(head, pivot);
    quickSortrec(pivot.next, tail);
  }

  public static Node quickSort(Node node) {
    Node tail = node, head = node;
    while (tail.next != null)
      tail = tail.next;
    quickSortrec(head, tail);
    return node;
  }
}