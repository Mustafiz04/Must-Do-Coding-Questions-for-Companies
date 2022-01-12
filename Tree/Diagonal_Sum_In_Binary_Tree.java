// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class GfG {

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

  static void printInorder(Node root) {
    if (root == null)
      return;

    printInorder(root.left);
    System.out.print(root.data + " ");

    printInorder(root.right);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      String s = br.readLine();
      Node root = buildTree(s);
      Tree g = new Tree();
      ArrayList<Integer> res = g.diagonalSum(root);
      for (Integer num : res)
        System.out.print(num + " ");
      System.out.println();
      t--;

    }
  }

}

class Tree {
  public static ArrayList<Integer> diagonalSum(Node root) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    if (root == null)
      return ans;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    sumDiagonalUtil(root, 0, map);
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      ans.add(e.getValue());
    }
    return ans;
  }

  public static void sumDiagonalUtil(Node root, int slope, TreeMap<Integer, Integer> map) {
    if (root == null)
      return;
    if (map.containsKey(slope)) {
      int prev = map.get(slope);
      map.put(slope, prev + root.data);
    } else {
      map.put(slope, root.data);
    }
    sumDiagonalUtil(root.right, slope, map);
    sumDiagonalUtil(root.left, slope + 1, map);
  }
}