import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class Leetcode131 {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] c = s.toCharArray();
        backTracking(c, 0, new Stack<>());
        return result;
    }

    private boolean isPalindrome(char[] c, int start, int end) {
        while (start < end) {
            if (c[start++] != c[end--]) {
                return false;
            }
        }
        return true;
    }

    private void backTracking(char[] c, int startIndex, Stack<String> path) {
        if (startIndex == c.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < c.length; i++) {
            if (isPalindrome(c, startIndex, i)) {
                path.push(new String(c, startIndex, i - startIndex + 1));
                backTracking(c, i + 1, path);
                path.pop();
            }
        }
    }

    public static void main(String[] args) {
        new Leetcode131().partition("aab");
    }
}
