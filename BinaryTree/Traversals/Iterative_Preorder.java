import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative_Preorder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stk = new Stack<>();
        stk.add(root);

        while (!stk.isEmpty()) {
            TreeNode temp = stk.pop();
            res.add(temp.val);
            // we will push item in reverse order, because Stack follows LIFO order
            // so in order to access left element first we have to push it at last
            if (temp.right != null) stk.push(temp.right);
            if (temp.left != null) stk.push(temp.left);
        }
        return res;   
    }
}
