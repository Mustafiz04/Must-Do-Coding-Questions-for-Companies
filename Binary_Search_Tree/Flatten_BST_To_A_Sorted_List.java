public class Solution {
  static TreeNode prev;

  public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
    TreeNode dummy = new TreeNode(-1);
    prev = dummy;

    Inorder(root);
    prev.left = null;
    prev.right = null;
    TreeNode<Integer> newList = dummy.right;

    return newList;
  }

  public static void Inorder(TreeNode curr) {
    if (curr == null)
      return;
    Inorder(curr.left);
    prev.left = null;
    prev.right = curr;
    prev = curr;
    Inorder(curr.right);
  }
}
