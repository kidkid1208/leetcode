import java.util.ArrayList;
import java.util.List;

/**
 * 输入：[4, 6, 7, 7]
 * 输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * @author lizehui
 * @date 2021/5/8 10:43
 */
public class Leetcode491 {
    private int[] nums;
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        backTracking(0);
        return result;
    }

    private void backTracking(int index) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }
        if (index == nums.length) {
            return;
        }
        List<Integer> used = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backTracking(i + 1);
            path.remove(path.size() - 1);
        }
    }
}
