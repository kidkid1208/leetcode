import java.util.HashMap;

/**
 * @author lizehui
 * @date 2021/4/22 17:31
 */
public class Leetcode106 {
    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        return buildTree(0, inorder.length - 1, 0, post.length - 1);
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps) {
            return null;
        }

        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
}
