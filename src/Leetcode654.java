/**
 * @author lizehui
 * @date 2021/4/23 10:50
 */
public class Leetcode654 {
    int[] num;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        num = nums;
        return constructMaximumBinaryTree(0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int s, int e) {
        if (s > e) {
            return null;
        }
        int id = 0;
        int max = Integer.MIN_VALUE;
        for (int i = s; i <= e; i++) {
            if (num[i] > max) {
                max = num[i];
                id = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTree(s, id - 1);
        node.right = constructMaximumBinaryTree(id + 1, e);
        return node;
    }
}
