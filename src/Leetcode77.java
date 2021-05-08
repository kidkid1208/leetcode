import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lizehui
 * @date 2021/5/6 14:59
 */
public class Leetcode77 {
    List<List<Integer>> result = new ArrayList<>();

    Stack<Integer> stack = new Stack<>();

    int k;
    int n;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        backCursing(1);
        return result;
    }

    public void backCursing(int startIndex) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int t = startIndex; t <= n - (k - stack.size()); t++) {
            if (!stack.contains(t)) {
                stack.push(t);
                backCursing(t + 1);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        new Leetcode77().combine(4, 2);
    }
}
