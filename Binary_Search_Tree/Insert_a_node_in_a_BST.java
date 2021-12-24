// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

class GFG {
  static Node buildTree(String str) {
    // Corner Case
    if (str.length() == 0 || str.equals('N'))
      return null;
    String[] s = str.split(" ");

    Node root = new Node(Integer.parseInt(s[0]));
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);

    // Starting from the second element
    int i = 1;
    while (!q.isEmpty() && i < s.length) {
      // Get and remove the front of the queue
      Node currNode = q.remove();

      // Get the current node's value from the string
      String currVal = s[i];

      // If the left child is not null
      if (!currVal.equals("N")) {

        // Create the left child for the current node
        currNode.left = new Node(Integer.parseInt(currVal));

        // Push it to the queue
        q.add(currNode.left);
      }

      // For the right child
      i++;
      if (i >= s.length)
        break;
      currVal = s[i];

      // If the right child is not null
      if (!currVal.equals("N")) {

        // Create the right child for the current node
        currNode.right = new Node(Integer.parseInt(currVal));

        // Push it to the queue
        q.add(currNode.right);
      }

      i++;
    }

    return root;
  }

  public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t > 0) {
      String s = br.readLine();
      Node root = buildTree(s);
      int key = Integer.parseInt(br.readLine().trim());
      Solution T = new Solution();
      root = T.insert(root, key);
      inorder(root);
      System.out.println();
      t--;
    }
  }

  static void inorder(Node root) {
    if (root == null)
      return;

    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }
}

class Solution {
  // Function to insert a node in a BST.
  Node insert(Node root, int Key) {
    // if( root == null ){
    // return new Node(Key);
    // }
    // if( root.data < Key ){
    // if( root.right != null ){
    // insert(root.right, Key);
    // }else{
    // root.right = new Node(Key);
    // }
    // }else if( root.data > Key ){
    // if( root.left != null ){
    // insert(root.left, Key);
    // }else{
    // root.left = new Node(Key);
    // }
    // }
    // return root;

    if (root == null) {
      return new Node(Key);
    }
    if (root.data < Key) {
      root.right = insert(root.right, Key);
    } else if (root.data > Key) {
      root.left = insert(root.left, Key);
    }
    return root;
  }
}