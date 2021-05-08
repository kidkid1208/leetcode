/**
 * @author lizehui
 * @date 2021/4/13 10:07
 */
public class Leetcode222 {

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
        public int countNodes(TreeNode root) {
            int result = 0;
            if (root == null) {
                return result;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
