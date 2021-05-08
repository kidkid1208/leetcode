import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lizehui
 * @date 2021/5/6 16:59
 */
public class Leetcode39 {
    private List<List<Integer>> result = new ArrayList<>();

    private int[] candidates;

    private Stack<Integer> stack = new Stack<>();

    private void backCursing(int sum, int target, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            stack.push(candidates[i]);
            backCursing(sum + candidates[i], target, i);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        backCursing(0, target, 0);
        return result;
    }
}
