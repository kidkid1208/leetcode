import java.util.ArrayList;
import java.util.List;

/**
 * @author lizehui
 * @date 2021/5/8 14:36
 */
public class Leetcode46 {
    private int[] nums;
    private boolean[] used;
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        used = new boolean[nums.length];
        backTracking();
        return result;
    }

    private void backTracking() {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backTracking();
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
