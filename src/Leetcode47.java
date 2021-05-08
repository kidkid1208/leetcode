import java.util.ArrayList;
import java.util.List;

/**
 * @author lizehui
 * @date 2021/5/8 14:52
 */
public class Leetcode47 {
    private int[] nums;
    private boolean[] used;
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        used = new boolean[nums.length];
        backTracking();
        return result;
    }

    private void backTracking() {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        List<Integer> usedNumber = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && !usedNumber.contains(nums[i])) {
                used[i] = true;
                usedNumber.add(nums[i]);
                path.add(nums[i]);
                backTracking();
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode47().permuteUnique(new int[]{1, 1, 2}));
    }
}
