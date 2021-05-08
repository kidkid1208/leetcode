import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lizehui
 * @date 2021/5/6 16:08
 */
public class Leetcode216 {
    List<List<Integer>> result = new ArrayList<>();

    Stack<Integer> stack = new Stack<>();

    int k;
    int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        backCursing(0, 1);
        return result;
    }

    public void backCursing(int sum, int startIndex) {
        if (sum > n) {
            return;
        }
        if (stack.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(stack));
            }
            return;
        }
        for (int t = startIndex; t <= 9 - sum; t++) {
            stack.push(t);
            backCursing(sum + t, t + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode216().combinationSum3(3, 7));
    }
}
