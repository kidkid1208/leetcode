import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizehui
 * @date 2021/3/30 15:05
 */
public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // i 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // left right 去重
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Leetcode15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
