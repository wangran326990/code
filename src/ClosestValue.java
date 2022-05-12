class ClosestValueSolution {
    double MIN_DIFF = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        Integer result = new Integer(-1);
        dfs(root, target, null, null, result);
        return result;
    }

    public void dfs(TreeNode root, double target, Integer pre, Integer next, Integer result) {
        if(root == null) return;

        if(pre != null) {
            if(MIN_DIFF > Math.abs(target - pre)) {
                result = pre;
            }
        }

        if(next != null) {
            if(MIN_DIFF > Math.abs(target - next)) {
                result = next;
            }
        }

        dfs(root.left, target, pre, root.val, result);

        dfs(root.right, target, root.val, next, result);
    }
}
public class ClosestValue {
    public static void main(String[] args) {
        ClosestValueSolution closestValueSolution = new ClosestValueSolution();
        TreeNode root = new TreeNode(4);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = left;
        rootLeft.right = right;
        closestValueSolution.closestValue(root,3.7);
    }
}