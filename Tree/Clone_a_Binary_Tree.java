
// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Tree {
  int data;
  Tree left, right, random;

  Tree(int d) {
    data = d;
    left = null;
    right = null;
    random = null;
  }
}

class CloneABT {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int q = sc.nextInt();
    int n, n1, n2;
    char lr;
    Tree root;
    while (q-- > 0) {
      n = sc.nextInt();
      root = null;
      Solution g = new Solution();
      while (n-- > 0) {
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        lr = sc.next().charAt(0);
        if (root == null) {
          root = new Tree(n1);
          switch (lr) {
            case 'L':
              root.left = new Tree(n2);
              break;
            case 'R':
              root.right = new Tree(n2);
              break;
          }
        } else {
          if (lr == 'X')
            clone(root, root, n1, n2);
          else
            insert(root, n1, n2, lr);
        }
      }
      try {
        Tree z = g.cloneTree(root);
        if (z == root)
          System.out.println("0");
        else {
          if (printInorder(root, z))
            System.out.println("1");

          else
            System.out.println("0");

        }
      } catch (ClassCastException ex) {
      }
    }
  }

  public static boolean printInorder(Tree a, Tree b) {
    if ((a == null) && (b == null))
      return true;

    if (a != null && b != null) {
      boolean check = ((a.data == b.data) && printInorder(a.left, b.left) && printInorder(a.right, b.right));

      if (a.random != null && b.random != null)
        return (check && (a.random.data == b.random.data));

      if (a.random == b.random)
        return check;

      return false;

    }

    /*
     * if(a.random.data == b.random.data)
     * if(printInorder(a.left,b.left)==1)
     * if(printInorder(a.right,b.right)==1)
     * return 1;
     */
    return false;

  }

  public static void clone(Tree root, Tree proot, int n1, int n2) {
    try {
      if (root == null && proot == null)
        return;
      if (n1 == root.data) {
        if (proot.data == n2)
          root.random = proot;
        else {
          clone(root, proot.left, n1, n2);
          clone(root, proot.right, n1, n2);
        }
      } else {
        clone(root.left, proot, n1, n2);
        clone(root.right, proot, n1, n2);
      }
    } catch (NullPointerException ex) {
    }
  }

  public static void insert(Tree root, int n1, int n2, char lr) {
    if (root == null)
      return;
    if (n1 == root.data) {
      switch (lr) {
        case 'L':
          root.left = new Tree(n2);
          break;
        case 'R':
          root.right = new Tree(n2);
          break;
      }
    } else {
      insert(root.left, n1, n2, lr);
      insert(root.right, n1, n2, lr);
    }
  }
}

class Solution {
  public Tree cloneTree(Tree tree) {
    if (tree == null)
      return null;
    HashMap<Tree, Tree> map = new HashMap<>();
    cloneLeftRight(tree, map);
    updateRandom(tree, map);

    return map.get(tree);
  }

  public Tree cloneLeftRight(Tree root, HashMap<Tree, Tree> map) {
    if (root == null)
      return null;
    map.put(root, new Tree(root.data));

    map.get(root).left = cloneLeftRight(root.left, map);
    map.get(root).right = cloneLeftRight(root.right, map);

    return map.get(root);
  }

  public void updateRandom(Tree root, HashMap<Tree, Tree> map) {
    if (map.get(root) == null)
      return;
    map.get(root).random = map.get(root.random);

    updateRandom(root.left, map);
    updateRandom(root.right, map);

  }
}