public class Flatten_Binary_Tree_to_Linked_List {
  public static void main(String[] args) {

  }

  public void flatten(TreeNode root) {
    // if(root == null) return;
    // Stack<TreeNode> s = new Stack<>();
    // s.push(root);

    // while(!s.isEmpty()){
    // TreeNode curr = s.pop();
    // if( curr.right != null ) s.push(curr.right);
    // if( curr.left != null ) s.push(curr.left);

    // if( !s.isEmpty() ){
    // curr.right = s.peek();
    // }
    // curr.left = null;
    // }

    if (root == null)
      return;
    TreeNode leftTree = root.left;
    TreeNode rightTree = root.right;

    root.left = null;
    flatten(leftTree);
    flatten(rightTree);

    root.right = leftTree;
    TreeNode curr = root;
    while (curr.right != null) {
      curr = curr.right;
    }
    curr.right = rightTree;
  }
}
