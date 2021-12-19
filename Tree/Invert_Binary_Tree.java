public class Invert_Binary_Tree {
  public static void main(String[] args) {

  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;

    TreeNode leftTree = invertTree(root.left);
    TreeNode rightTree = invertTree(root.right);

    root.left = rightTree;
    root.right = leftTree;

    return root;
  }
}
