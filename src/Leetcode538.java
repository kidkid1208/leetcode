import java.util.ArrayList;
import java.util.List;

/**
 * @author lizehui
 * @date 2021/4/30 11:12
 * 注：反中序更佳
 */
public class Leetcode538 {
    private List<TreeNode> list = new ArrayList<>();

    public TreeNode convertBST(TreeNode root) {
        preList(root);
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            list.get(i).val += sum;
            sum = list.get(i).val;
        }
        return root;
    }

    public void preList(TreeNode root) {
        if (root == null) {
            return;
        }
        preList(root.left);
        list.add(root);
        preList(root.right);
    }
}
