import java.util.Stack;

/**
 * 左叶子之和
 * @author lizehui
 * @date 2021/4/20 11:11
 */
public class Leetcode404 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            int sum = 0;
            Stack<TreeNode> nodes = new Stack<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                    nodes.push(node.left);
                }
                if (node.right != null) {
                    nodes.push(node.right);
                }

            }
            return sum;
        }
    }
}
