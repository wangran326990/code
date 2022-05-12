import data.TreeNode;

import java.util.Stack;

public class BinaryTreeMaximumPathSum {
    int maxPathSum = 0;
    public static int maxPathSum(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();

        }
        return 1;
    }
}
