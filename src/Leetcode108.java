

/**
 * @author lizehui
 * @date 2021/4/30 11:23
 */
public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, s, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, e);
        return root;
    }

    public static void main(String[] args) {
        new Leetcode108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
