import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lizehui
 * @date 2021/4/22 16:52
 */
public class Leetcode113 {

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
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return res;
            }
            List<Integer> list = new Stack<>();
            int sum = 0;
            findPath(root, targetSum, sum, list);
            return res;
        }

        public void findPath(TreeNode node, int targetSum, int sum, List<Integer> list) {
            list.add(node.val);
            sum += node.val;
            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    res.add(new ArrayList<>(list));
                }
            }
            if (node.left == null && node.right != null) {
                findPath(node.right, targetSum, sum, list);
            }
            if (node.right == null && node.left != null) {
                findPath(node.left, targetSum, sum, list);
            }
            if (node.right != null && node.left != null) {
                findPath(node.left, targetSum, sum, list);
                findPath(node.right, targetSum, sum, list);
            }
            list.remove(list.size() - 1);
        }
    }
}
