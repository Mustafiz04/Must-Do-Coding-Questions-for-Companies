// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
  int data;
  Node next, prev;

  Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());

    while (t-- > 0) {
      int n = Integer.parseInt(read.readLine());
      String str[] = read.readLine().trim().split(" ");
      Node head = null, tail = null;
      for (int i = 0; i < n; i++) {
        int data = Integer.parseInt(str[i]);
        if (head == null) {
          head = new Node(data);
          tail = head;
        } else {
          tail.next = new Node(data);
          tail.next.prev = tail;
          tail = tail.next;
        }
      }
      head = reverseDLL(head);
      if (verify(head))
        displayList(head);
      else
        System.out.print("Your pointers are not correctly connected");
      System.out.println();

    }
  }

  public static void displayList(Node head) {
    // Head to Tail
    while (head.next != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.print(head.data);

  }

  public static Node reverseDLL(Node head) {
    Node curr = head, next = null, prev = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      curr.prev = next;
      prev = curr;
      curr = next;
    }
    return prev;
  }


  public static boolean verify(Node head) {
    int fl = 0;
    int bl = 0;

    Node temp = head;

    while (temp.next != null) {
      temp = temp.next;
      fl++;
    }

    while (temp.prev != null) {
      temp = temp.prev;
      bl++;
    }

    return fl == bl;
  }
}