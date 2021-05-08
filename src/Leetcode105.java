import java.util.HashMap;
import java.util.Map;

/**
 * @author lizehui
 * @date 2021/4/23 10:36
 */
public class Leetcode105 {
    int[] pre;
    Map<Integer, Integer> in = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        int i = 0;
        for (int n : inorder) {
            in.put(n, i++);
        }
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        int val = pre[ps];
        TreeNode root = new TreeNode(val);
        int id = in.get(val);
        root.left = buildTree(ps + 1, ps + id - is, is, id - 1);
        root.right = buildTree(pe - ie + id + 1, pe, id + 1, ie);
        return root;
    }
}
