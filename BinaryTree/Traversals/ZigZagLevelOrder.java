
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // TreeNode(int x){
        //     val = x;
        //     left = null;
        //     right = null;
        // }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> dq = new LinkedList<>();
        int level = 0;
        dq.add(root);

        while (!dq.isEmpty()) {
            int len = dq.size();
            List<Integer> aux = new ArrayList<>();
            if (level % 2 == 0) {
                for (int i = 0; i < len; i++) {
                    TreeNode temp = dq.remove();
                    aux.add(temp.val);

                    if (temp.left != null) dq.add(temp.left);
                    if (temp.right != null) dq.add(temp.right);
                }
            }else {
                for (int i = 0; i < len; i++) {
                    TreeNode temp = dq.removeLast();
                    aux.add(temp.val);

                    if (temp.right != null) dq.addFirst(temp.right);
                    if (temp.left != null) dq.addFirst(temp.left);
                }
            }

            res.add(aux);
            level++;
        }
        return res;
    }
}
