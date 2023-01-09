import java.util.ArrayList;
import java.util.List;

public class Recursive_Preorder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    List<Integer> pre;
    public List<Integer> preorderTraversal(TreeNode root) {
        pre = new ArrayList<>();
        traverse(root);
        return pre;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        pre.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}