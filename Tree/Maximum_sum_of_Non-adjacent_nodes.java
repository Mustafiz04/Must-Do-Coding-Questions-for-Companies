// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
  int data;
  Node left, right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class MaxSum {
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

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      String s = br.readLine();
      Node root = buildTree(s);
      Solution ob = new Solution();
      int ans = ob.getMaxSum(root);
      System.out.println(ans);
      t--;
    }
  }
}


class Pair {
  int include, exclude;

  Pair(int include, int exclude) {
    this.include = include;
    this.exclude = exclude;
  }
}

class Solution {
  static int getMaxSum(Node root) {
    Pair ans = maxSum(root);
    return Math.max(ans.include, ans.exclude);
  }

  static Pair maxSum(Node root) {
    if (root == null) {
      return new Pair(0, 0);
    }
    Pair left = maxSum(root.left);
    Pair right = maxSum(root.right);

    int include = left.exclude + right.exclude + root.data;
    int exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

    return new Pair(include, exclude);
  }
}
