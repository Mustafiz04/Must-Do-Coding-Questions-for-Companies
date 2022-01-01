// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
  int data;
  Node left, right;

  public Node(int data) {
    this.data = data;
  }
}

class GFG {

  static Node buildTree(String str) {

    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }

    String ip[] = str.split(" ");
    // Create the root of the tree
    Node root = new Node(Integer.parseInt(ip[0]));
    // Push the root to the queue

    Queue<Node> queue = new LinkedList<>();

    queue.add(root);
    // Starting from the second element

    int i = 1;
    while (queue.size() > 0 && i < ip.length) {

      // Get and remove the front of the queue
      Node currNode = queue.peek();
      queue.remove();

      // Get the current node's value from the string
      String currVal = ip[i];

      // If the left child is not null
      if (!currVal.equals("N")) {

        // Create the left child for the current node
        currNode.left = new Node(Integer.parseInt(currVal));
        // Push it to the queue
        queue.add(currNode.left);
      }

      // For the right child
      i++;
      if (i >= ip.length)
        break;

      currVal = ip[i];

      // If the right child is not null
      if (!currVal.equals("N")) {

        // Create the right child for the current node
        currNode.right = new Node(Integer.parseInt(currVal));

        // Push it to the queue
        queue.add(currNode.right);
      }
      i++;
    }

    return root;
  }

  public static void inorder(Node root) {
    if (root == null)
      return;

    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String s = br.readLine();
      Node root = buildTree(s);
      Solution obj = new Solution();
      int res = obj.sumOfLongRootToLeafPath(root);
      System.out.println(res);
    }
  }
}

class Solution {
  int maxSum = Integer.MIN_VALUE;

  public int sumOfLongRootToLeafPath(Node root) {
    int[] ans = rootLeafSum(root);
    return ans[1];
  }

  int[] rootLeafSum(Node root) {
    if (root == null) {
      return new int[] { 0, 0 };
    }
    int[] left = rootLeafSum(root.left);
    int[] right = rootLeafSum(root.right);

    if (left[0] > right[0]) {
      return new int[] { left[0] + 1, left[1] + root.data };
    } else if (left[0] < right[0]) {
      return new int[] { right[0] + 1, right[1] + root.data };
    } else {
      return new int[] { left[0] + 1, Math.max(left[1], right[1]) + root.data };
    }
  }
}