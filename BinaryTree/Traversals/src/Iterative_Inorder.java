import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative_Inorder {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int _val){
            val = _val;
            left = null;
            right = null;
        }
    }

    public List<Integer> inorder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

}

