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

  public static void preorder(Node root) {
    if (root == null)
      return;
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String s = br.readLine();
      Node root = buildTree(s);
      Solution obj = new Solution();
      List<Node> res = obj.printAllDups(root);
      for (int i = 0; i < res.size(); i++) {
        preorder(res.get(i));
        System.out.println();
      }

    }
  }
}

class Solution {
  HashMap<String, Integer> hs = new HashMap<>();
  ArrayList<Node> ar = new ArrayList<>();

  public List<Node> printAllDups(Node root) {
    hs.clear();
    ar.clear();
    solve(root);
    return ar;
  }

  String solve(Node root) {
    if (root == null)
      return "$";
    String s = "";

    s += String.valueOf(root.data);
    s += " ";
    s += solve(root.left);
    s += " ";
    s += solve(root.right);
    s += " ";
    if (hs.containsKey(s) && hs.get(s) == 1) {
      ar.add(root);
      hs.put(s, 2);
    } else {
      hs.put(s, 1);
    }
    return s;
  }

}