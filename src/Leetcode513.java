import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 左下角的值
 *
 * @author lizehui
 * @date 2021/4/20 11:36
 */
public class Leetcode513 {
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
        public int findBottomLeftValue(TreeNode root) {
            int res = 0;
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            int i = list.size();
            while (i > 0) {
                res = list.get(0).val;
                for (int j = 0; j < i; j++) {
                    TreeNode node = list.get(0);
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                    list.remove(0);
                }
                i = list.size();
            }
            return res;
        }
    }
}
