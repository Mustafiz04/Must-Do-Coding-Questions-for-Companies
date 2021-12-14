
// { Driver Code Starts
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class circular_LinkedList {
  Node head, head1, head2; // head of lisl
  // Node last = null;
  Node last = null;

  /* Linked list Node */

  /* Utility functions */

  /* Inserts a new Node at front of the list. */
  public void addToTheLast(Node node) {

    if (head == null) {
      head = node;

    } else {
      Node temp = head;
      while (temp.next != null)
        temp = temp.next;

      temp.next = node;
    }
  }

  /* Function to print linked list */
  void printList(Node node) {
    Node temp = node;
    if (node != null) {
      do {
        System.out.print(temp.data + " ");
        temp = temp.next;
      } while (temp != node);
    }
    System.out.println();
  }

  void circular() {
    last = head;
    while (last.next != null)
      last = last.next;
    last.next = head;
    // System.out.println(last);
  }

  /* Drier program to test above functions */
  public static void main(String args[]) {

    /*
     * Constructed Linked List is 1->2->3->4->5->6->
     * 7->8->8->9->null
     */
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      circular_LinkedList llist = new circular_LinkedList();
      int a1 = sc.nextInt();
      Node head = new Node(a1);
      llist.addToTheLast(head);
      for (int i = 1; i < n; i++) {
        int a = sc.nextInt();
        llist.addToTheLast(new Node(a));

      }
      /*
       * Node x = head;
       * while(x!=null)
       * {
       * System.out.print(x.data+" ");
       * x = x.next;
       * }
       */
      llist.circular();
      // int k=sc.nextInt();
      gfg g = new gfg();
      // System.out.println(g.getCount(llist));
      g.splitList(llist);
      llist.printList(llist.head1);
      llist.printList(llist.head2);
      // llist.printList();
      // llist.head = llist.reverse(llist.head);
      // llist.printList();

      t--;
    }
  }
}


class gfg {
  void splitList(circular_LinkedList list) {
    Node head = list.head;
    list.head1 = head;
    Node slow = head;
    Node fast = head.next;

    while (fast != head && fast.next != head) {
      fast = fast.next.next;
      slow = slow.next;
    }

    list.head2 = slow.next;
    slow.next = list.head1;
    Node curr = list.head2;

    while (curr.next != head) {
      curr = curr.next;
    }

    curr.next = list.head2;
  }
}