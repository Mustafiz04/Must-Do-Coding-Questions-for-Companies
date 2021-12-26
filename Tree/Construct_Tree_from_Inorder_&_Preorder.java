
// { Driver Code Starts
import java.util.*;
import java.io.*;

class Node {
  int data;
  Node left, right;

  Node(int key) {
    data = key;
    left = right = null;
  }
}

class GFG {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      Node root = null;
      int inorder[] = new int[n];
      int preorder[] = new int[n];
      for (int i = 0; i < n; i++)
        inorder[i] = sc.nextInt();

      for (int i = 0; i < n; i++)
        preorder[i] = sc.nextInt();

      Solution ob = new Solution();
      root = ob.buildTree(inorder, preorder, n);
      postOrdrer(root);
      System.out.println();
    }
  }

  public static void postOrdrer(Node root) {
    if (root == null)
      return;

    postOrdrer(root.left);
    postOrdrer(root.right);
    System.out.print(root.data + " ");
  }
}

class Solution {
  static int i = 0;

  public static Node buildTree(int inorder[], int preorder[], int n) {
    i = 0;
    return tree(inorder, preorder, 0, n - 1);
  }

  static Node tree(int inorder[], int preorder[], int x, int n) {
    if (x > n)
      return null;
    Node root = new Node(preorder[i++]);
    int j;
    for (j = x; j <= n; j++)
      if (inorder[j] == root.data)
        break;
    root.left = tree(inorder, preorder, x, j - 1);
    root.right = tree(inorder, preorder, j + 1, n);
    return root;
  }
}
