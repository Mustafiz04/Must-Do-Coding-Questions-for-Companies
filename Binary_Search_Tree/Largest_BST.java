// { Driver Code Starts
//Initial Template for Java

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

      // Get the curr node's value from the string
      String currVal = s[i];

      // If the left child is not null
      if (!currVal.equals("N")) {

        // Create the left child for the curr node
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

        // Create the right child for the curr node
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

      Solution T = new Solution();
      System.out.println(T.largestBst(root));

      t--;
    }
  }
}


class Solution {
  static int largestBst(Node root) {
    ArrayList<Integer> arr = new ArrayList<>();
    arr = solve(root);
    return arr.get(1);
  }

  static ArrayList<Integer> solve(Node root) {
    ArrayList<Integer> ans = new ArrayList<>();
    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;
    ArrayList<Integer> a1 = new ArrayList<>();

    if (root == null) {
      a1.add(1);
      a1.add(0);
      a1.add(max);
      a1.add(min);
      return a1;
    }

    if (root.left == null && root.right == null) {
      a1.add(1);
      a1.add(1);
      a1.add(root.data);
      a1.add(root.data);
      return a1;
    }

    ArrayList<Integer> l = new ArrayList<>();
    ArrayList<Integer> r = new ArrayList<>();
    l = solve(root.left);
    r = solve(root.right);
    if (l.get(0) == 1 && r.get(0) == 1) {
      if (root.data > l.get(3) && root.data < r.get(2)) {
        int x = l.get(2);
        int y = r.get(3);
        if (x == max)
          x = root.data;
        if (y == min)
          y = root.data;
        ans.add(1);
        ans.add(l.get(1) + r.get(1) + 1);
        ans.add(x);
        ans.add(y);
        return ans;
      }
    }
    ans.add(0);
    ans.add(Math.max(l.get(1), r.get(1)));
    ans.add(0);
    ans.add(0);
    return ans;
  }
}