import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizehui
 * @date 2021/5/7 17:42
 */
public class Leetcode78 {

    private int[] nums;

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        backTracking(0);
        return result;
    }

    private void backTracking(int startIndex) {
        if (startIndex == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[startIndex]);
        backTracking(startIndex + 1);
        path.remove(path.size() - 1);
        backTracking(startIndex + 1);
    }
}
