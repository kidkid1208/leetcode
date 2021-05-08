import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * @author lizehui
 * @date 2021/5/8 10:18
 */
public class Leetcode90 {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private int[] used;

    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        used = new int[nums.length];
        backTracking(0);
        return result;
    }

    private void backTracking(int startIndex) {
        if (startIndex == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (startIndex > 0 && nums[startIndex] == nums[startIndex - 1] && used[startIndex - 1] == 0) {
            backTracking(startIndex + 1);
            return;
        }
        path.add(nums[startIndex]);
        used[startIndex] = 1;
        backTracking(startIndex + 1);
        used[startIndex] = 0;
        path.remove(path.size() - 1);
        backTracking(startIndex + 1);
    }
}
