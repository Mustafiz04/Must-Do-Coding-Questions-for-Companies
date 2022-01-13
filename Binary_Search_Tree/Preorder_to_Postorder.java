// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}

class GFG {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      String[] inputline = br.readLine().trim().split(" ");
      int n = Integer.parseInt(inputline[0]);
      inputline = br.readLine().trim().split(" ");
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputline[i]);
      }

      Node res = post_order(arr, n);
      printPostorder(res);
      System.out.println();
    }
  }

  // } Driver Code Ends
  // User function Template for Java

  // Function that constructs BST from its preorder traversal.
  public static Node post_order(int pre[], int size) {
    int left = 0, right = size - 1;
    return buildTree(pre, left, right);
  }

  public static Node buildTree(int[] pre, int left, int right) {
    if (left > right)
      return null;

    Node root = new Node(pre[left]);
    int i = left + 1;
    while (i <= right && pre[i] < pre[left])
      i++;

    root.left = buildTree(pre, left + 1, i - 1);
    root.right = buildTree(pre, i, right);
    return root;
  }

  // { Driver Code Starts.

  public static void printInorder(Node node) {
    if (node == null) {
      return;
    }
    printInorder(node.left);
    System.out.print(node.data + " ");
    printInorder(node.right);
  }

  public static void printPostorder(Node node) {
    if (node == null) {
      return;
    }
    printPostorder(node.left);
    printPostorder(node.right);
    System.out.print(node.data + " ");
  }

  public static void printPreorder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.data + " ");
    printPreorder(node.left);
    printPreorder(node.right);
  }

} // } Driver Code Ends