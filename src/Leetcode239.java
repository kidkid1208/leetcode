import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 */
public class Leetcode239 {
    // deque 双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int[] res = new int[l - k + 1];
        for (int i = k - 1; i < l; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
            if (!deque.isEmpty() && deque.peekFirst() == nums[i - k + 1]) {
                deque.pollFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Leetcode239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7},3);
    }
}
