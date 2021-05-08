import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author lizehui
 * @date 2021/5/7 10:57
 */
public class Leetcode40 {
    private int[] candidates;

    private List<List<Integer>> result = new ArrayList<>();

    private Stack<Integer> path = new Stack<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        backCursing(0, target, 0);
        return result;
    }

    private void backCursing(int sum, int target, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.push(candidates[i]);
            backCursing(sum + candidates[i], target, i + 1);
            path.pop();
        }
    }
}
