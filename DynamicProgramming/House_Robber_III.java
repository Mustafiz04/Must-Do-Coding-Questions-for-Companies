package DynamicProgramming;

public class House_Robber_III {
  public static void main(String[] args) {

  }

  public int rob(TreeNode root) {
    int[] ans = _helper(root);
    return Math.max(ans[0], ans[1]);
  }

  public int[] _helper(TreeNode root) {
    if (root == null)
      return new int[] { 0, 0 };

    int[] left = _helper(root.left);
    int[] right = _helper(root.right);

    int rob = root.val + left[1] + right[1];
    int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return new int[] { rob, notRob };
  }
}
