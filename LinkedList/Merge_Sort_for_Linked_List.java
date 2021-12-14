// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

class Driverclass {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      Node head = new Node(sc.nextInt());
      Node tail = head;
      while (n-- > 1) {
        tail.next = new Node(sc.nextInt());
        tail = tail.next;
      }

      head = new Solution().mergeSort(head);
      printList(head);
      System.out.println();
    }
  }

  public static void printList(Node head) {
    if (head == null)
      return;

    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }
}

class Solution {
  static Node mergeSort(Node head) {
    Node curr = head;
    if (curr == null || curr.next == null) {
      return curr;
    }

    Node middle = findMiddle(head);
    Node nextToMiddle = middle.next;
    middle.next = null;

    Node left = mergeSort(head);
    Node right = mergeSort(nextToMiddle);

    head = merge(left, right);
    return head;
  }

  static Node findMiddle(Node head) {
    if (head == null)
      return null;
    Node slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  static Node merge(Node head1, Node head2) {
    Node merged = new Node(-1);
    Node temp = merged;
    while (head1 != null && head2 != null) {
      if (head1.data < head2.data) {
        temp.next = head1;
        head1 = head1.next;
      } else {
        temp.next = head2;
        head2 = head2.next;
      }
      temp = temp.next;
    }

    // While head1 is not null
    while (head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;
    }

    // While head2 is not null
    while (head2 != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;
    }
    return merged.next;
  }

  // static Node merge(Node left, Node right){
  // if( left == null ) return right;
  // if( right == null ) return left;

  // Node result = null;

  // if( left.data < right.data ){
  // result = left;
  // result.next = merge(left.next, right);
  // }else{
  // result = right;
  // result.next = merge(left, right.next);
  // }

  // return result;
  // }
}
