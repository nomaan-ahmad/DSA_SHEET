// https://leetcode.com/problems/same-tree/description/

public class SameTree {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;

        return 
        (p.val == q.val) && 
        isSameTree(p.left, q.left) && 
        isSameTree(p.right, q.right);
    }
}
