import java.util.ArrayList;
import java.util.List;

/**
 * @author lizehui
 * @date 2021/4/13 10:30
 */
public class Leetcode257 {

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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            String s = "";
            findPath(root, res, s);
            return res;
        }

        public void findPath(TreeNode treeNode, List<String> list, String s) {
            if (treeNode == null) {
                return;
            }
            if (treeNode.left == null && treeNode.right == null) {
                s += treeNode.val;
                list.add(s);
                return;
            }
            if (treeNode.left == null) {
                s += treeNode.val + "->";
                findPath(treeNode.right, list, s);
                return;
            }
            if (treeNode.right == null) {
                s += treeNode.val + "->";
                findPath(treeNode.left, list, s);
                return;
            }
            s += treeNode.val + "->";
            findPath(treeNode.right, list, s);
            findPath(treeNode.left, list, s);
        }
    }
}
