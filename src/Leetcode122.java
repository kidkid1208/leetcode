/**
 * @author lizehui
 * @date 2021/4/22 16:35
 */
public class Leetcode122 {

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root==null){
                return false;
            }
            int sum = 0;
            return findPath(root, targetSum, sum);
        }

        public boolean findPath(TreeNode node, int targetSum, int sum) {
            if (node.left == null && node.right == null) {
                return targetSum == sum + node.val;
            }
            if (node.left == null) {
                return findPath(node.right, targetSum, sum + node.val);
            }
            if (node.right == null) {
                return findPath(node.left, targetSum, sum + node.val);
            }
            return findPath(node.right, targetSum, sum + node.val) || findPath(node.left, targetSum, sum + node.val);
        }
    }
}
